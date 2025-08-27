package lll.whobuys.stock;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Stock {
    private String ticker;
    private String stockName;
    private Double price;
    private Double priceEarningRatio;

    public Stock(String ticker, String stockName, Double price, Double priceEarningRatio) {
        this.ticker = ticker;
        this.stockName = stockName;
        this.price = price;
        this.priceEarningRatio = priceEarningRatio;
    }
}
