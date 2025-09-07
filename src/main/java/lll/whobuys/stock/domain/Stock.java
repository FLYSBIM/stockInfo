package lll.whobuys.stock.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@Table
@Entity
public class Stock {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stock_id", updatable = false)
    private Long stockId;

    @Embedded
    StockName stockName;

    @Embedded
    StockPrice stockPrice;

    public String getName(){
        return stockName.getStockName();
    }

    public Double getPrice(){
        return stockPrice.getPrice();
    }

}
