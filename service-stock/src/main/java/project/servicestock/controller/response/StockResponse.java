package project.servicestock.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.servicestock.model.Stocks;
import project.servicestock.model.entity.StockEntity;
import project.servicestock.model.entity.StocksEntity;

@Getter
@AllArgsConstructor
public class StockResponse {
    private String stockCode;
    private String stockType;
    private String stockName;
    private String type;
    private String close;
    private String compareToPreviousClosePrice;
    private String compareToPreviousPrice;
    private String fluctuationsRatio;
    private String accumulatedTradingVolume;
    private String accumulatedTradingValue;
    private String localTradedAt;
    private String marketValue;

    public static StockResponse fromStock(Stocks stock) {
        return new StockResponse(
            stock.getStockCode(),
            stock.getStockType(),
            stock.getStockName(),
            stock.getType(),
            stock.getClose(),
            stock.getCompareToPreviousClosePrice(),
            stock.getCompareToPreviousPrice(),
            stock.getFluctuationsRatio(),
            stock.getAccumulatedTradingVolume(),
            stock.getAccumulatedTradingValue(),
            stock.getLocalTradedAt(),
            stock.getMarketValue()
        );
    }
}