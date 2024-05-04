package project.servicestock.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import project.servicestock.BaseTimeEntity;

import javax.persistence.*;

@Entity(name = "stocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@EnableJpaAuditing
public class StocksEntity extends BaseTimeEntity {

    @Id
    private String stockCode;

    @Column(name = "stocktype")
    private String stockType; // international or domestic

    @Column(name = "stockname")
    private String stockName;

    @Column(name = "type")
    private String type; // kospi or kosdak

    @Column(name = "close")
    private String close;

    @Column(name = "comparetopreviouscloseprice")
    private String compareToPreviousClosePrice;

    @Column(name = "comparetopreviousprice")
    private String compareToPreviousPrice;

    @Column(name = "luctuationsratio")
    private String fluctuationsRatio;

    @Column(name = "accumulatedtradingvolume")
    private String accumulatedTradingVolume;

    @Column(name = "accumulatedtradingvalue")
    private String accumulatedTradingValue;

    @Column(name = "localtradedat")
    private String localTradedAt;

    @Column(name = "marketvalue")
    private String marketValue;

    public static StocksEntity of(String stockCode, String stockType, String stockName, String type, String close,
                                  String compareToPreviousClosePrice, String compareToPreviousPrice, String fluctuationsRatio,
                                  String accumulatedTradingVolume, String accumulatedTradingValue, String localTradedAt, String marketValue) {
        StocksEntity entity = new StocksEntity();
        entity.setStockCode(stockCode);
        entity.setStockType(stockType);
        entity.setStockName(stockName);
        entity.setType(type);
        entity.setClose(close);
        entity.setCompareToPreviousClosePrice(compareToPreviousClosePrice);
        entity.setCompareToPreviousPrice(compareToPreviousPrice);
        entity.setFluctuationsRatio(fluctuationsRatio);
        entity.setAccumulatedTradingVolume(accumulatedTradingVolume);
        entity.setAccumulatedTradingValue(accumulatedTradingValue);
        entity.setLocalTradedAt(localTradedAt);
        entity.setMarketValue(marketValue);
        return entity;
    }
}
