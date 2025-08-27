package lll.whobuys.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public boolean highPriceEarningRatioStock(Stock stock) {
        return stock.getPriceEarningRatio() > getAveragePriceEarningRatio();
    }

    public double getAveragePriceEarningRatio() {
        double averagePriceEarningRatio = 0.0;
        List<Stock>stocks = stockRepository.findAll();
        for(Stock stock : stocks) {
            averagePriceEarningRatio += stock.getPriceEarningRatio();
        }
        return averagePriceEarningRatio / stocks.size();
    }
}
