package lll.whobuys.stock.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class StockPrice {

    @Column(name = "stock_price", nullable = false)
    private Double price;

    public StockPrice(Double price) {
        this.price = price;
    }
}
