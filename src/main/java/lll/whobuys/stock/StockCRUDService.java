package lll.whobuys.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockCRUDService {

    StockRepository stockRepository;

    @Autowired
    StockCRUDService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockByTicker(String ticker) {
        return stockRepository.findByTicker(ticker);
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void updateStock(String stockTicker, Stock stock) {
        stockRepository.update(stockTicker,stock);
    }

    public void deleteStock(String stockTicker) {
        stockRepository.delete(stockTicker);
    }
}
