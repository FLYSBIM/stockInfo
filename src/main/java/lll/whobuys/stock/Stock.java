package lll.whobuys.stock;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter @Setter
public class Stock {
    private String ticker;
    private String stockName;
    private Double price;
    private Double priceEarningRatio;
    private Long issuedShare;
    private Double marketCap;
    private String marketCapString;

    public Stock(String ticker, String stockName, Double price, Double priceEarningRatio,Long issuedShare) {
        this.ticker = ticker;
        this.stockName = stockName;
        this.price = price;
        this.priceEarningRatio = priceEarningRatio;
        this.issuedShare = issuedShare;
        this.marketCap = price * issuedShare;

        BigDecimal marketCapBigDecimal = new BigDecimal(this.marketCap);
        BigDecimal billion = new BigDecimal("1000000000");

        BigDecimal marketCapInBillion = marketCapBigDecimal.divide(billion, 0, RoundingMode.HALF_UP);

        this.marketCapString = marketCapInBillion.toPlainString() + "B";
    }
}
