package lll.whobuys.stock.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class StockName {

    @Column(name = "stock_name",nullable = false)
    private String stockName;

    @Column(name = "stock_ticker",nullable = false)
    private String stockTicker;

    public StockName(final String stockName, final String stockTicker) {
        this.stockName = stockName;
        this.stockTicker = stockTicker;
    }
}
