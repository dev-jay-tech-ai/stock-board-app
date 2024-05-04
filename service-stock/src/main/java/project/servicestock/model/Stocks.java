package project.servicestock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.servicestock.model.entity.StocksEntity;
@Getter
@AllArgsConstructor
public class Stocks {
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

    public static Stocks fromEntity(StocksEntity entity) {
        return new Stocks(
                entity.getStockCode(),
                entity.getStockType(),
                entity.getStockName(),
                entity.getType(),
                entity.getClose(),
                entity.getCompareToPreviousClosePrice(),
                entity.getCompareToPreviousPrice(),
                entity.getFluctuationsRatio(),
                entity.getAccumulatedTradingVolume(),
                entity.getAccumulatedTradingValue(),
                entity.getLocalTradedAt(),
                entity.getMarketValue()
        );
    }
}
