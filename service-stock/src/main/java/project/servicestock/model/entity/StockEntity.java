package project.servicestock.model.entity;

import project.servicestock.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import project.servicestock.model.StockType;

import javax.persistence.*;

@Entity(name = "stock")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@EnableJpaAuditing
public class StockEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stockname")
    private String stockName;

    @Column(name = "stockcode")
    private String stockCode;

    @Enumerated(EnumType.STRING)
    private StockType type;

    @Column(name = "date")
    private String date;

    @Column(name = "open")
    private String open;

    @Column(name = "high")
    private String high;

    @Column(name = "low")
    private String low;

    @Column(name = "close")
    private String close;

    @Column(name = "volume")
    private String volume;

    public StockEntity(String stockName, String stockCode, String date, String open, String high, String low, String close, String volume, StockType type) {
        this.stockName = stockName;
        this.stockCode = stockCode;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.type = type;
    }

}