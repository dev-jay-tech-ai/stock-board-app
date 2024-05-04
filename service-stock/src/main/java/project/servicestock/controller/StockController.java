package project.servicestock.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import project.servicestock.controller.response.StockResponse;
import project.servicestock.model.StockType;
import project.servicestock.model.entity.StockEntity;
import project.servicestock.model.entity.StocksEntity;
import project.servicestock.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import project.servicestock.service.StocksService;
import project.serviceuser.controller.response.Response;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;

@RestController
@RequestMapping("/api/v1/stocks")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;
    private final StocksService stocksService;

    @GetMapping("/initial")
    public void parseInitialData() {
        try {
            URL url = new URL("https://fchart.stock.naver.com/sise.nhn?symbol=005380&timeframe=day&count=1000&requestType=0");

            System.out.println("get stock data");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            try (InputStream inputStream = url.openStream()) {
                Document document = builder.parse(inputStream);
                // Get the root element
                Element root = document.getDocumentElement();
                NodeList chartDataList = root.getElementsByTagName("chartdata");
                Element chartDataElement = (Element) chartDataList.item(0);

                String code = chartDataElement.getAttribute("symbol");
                String name = chartDataElement.getAttribute("name");
                StockType type = StockType.KOSPI;

                // Get the item elements
                NodeList itemList = chartDataElement.getElementsByTagName("item");
                for (int i = 0; i < itemList.getLength(); i++) {
                    Node itemNode = itemList.item(i);
                    if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element itemElement = (Element) itemNode;
                        String data = itemElement.getAttribute("data");
                        String[] dataElements = data.split("\\|");
                        if (dataElements.length == 6) {
                            String date = dataElements[0];
                            String open = dataElements[1];
                            String high = dataElements[2];
                            String low = dataElements[3];
                            String close = dataElements[4];
                            String transaction = dataElements[5];
                            // Create and save the Stock object
                            StockEntity stock = new StockEntity(name, code, date, open, high, low, close, transaction, type);
                            stockService.transfer(stock);
                            System.out.println("Stock data saved: " + stock);
                        } else {
                            System.out.println("Invalid data format: " + data);
                        }
                    }
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{type}")
    public void parseStockData(@PathVariable String type) {
        try {
            String url = "https://m.stock.naver.com/api/stocks/marketValue/"+ type.toUpperCase() +"?page=1&pageSize=20";

            RestTemplate restTemplate = new RestTemplate();
            String jsonData = restTemplate.getForObject(url, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);
            JsonNode stocksNode = jsonNode.get("stocks");
            for (JsonNode stockNode : stocksNode) {
                StocksEntity stock = new StocksEntity();
                stock.setStockCode(stockNode.get("itemCode").asText());
                stock.setStockType(stockNode.get("stockType").asText());
                stock.setStockName(stockNode.get("stockName").asText());
                stock.setType(stockNode.get("sosok").asText());
                stock.setClose(stockNode.get("closePrice").asText());
                stock.setCompareToPreviousClosePrice(stockNode.get("compareToPreviousClosePrice").asText());
                stock.setCompareToPreviousPrice(stockNode.get("compareToPreviousPrice").get("text").asText());
                stock.setFluctuationsRatio(stockNode.get("fluctuationsRatio").asText());
                stock.setAccumulatedTradingVolume(stockNode.get("accumulatedTradingVolume").asText());
                stock.setAccumulatedTradingValue(stockNode.get("accumulatedTradingValue").asText());
                stock.setLocalTradedAt(stockNode.get("localTradedAt").asText());
                stock.setMarketValue(stockNode.get("marketValue").asText());
                // Save the entity to the database
                stocksService.transfer(stock);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping
    public Response<Page<StockResponse>> list(Pageable pageable, Authentication authentication) {
        return Response.success(stocksService.list(pageable).map(StockResponse::fromStock));
    }


}
