package lll.whobuys.stock;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockRepository {
    private static Map<String,Stock>stocks=new HashMap<>();

    public Stock save(Stock stock){
        stocks.put(stock.getTicker(),stock);
        return stock;
    }

    public Stock findByTicker(String ticker){
        return stocks.get(ticker);
    }

    public List<Stock> findAll(){
        return new ArrayList<>(stocks.values());
    }

    public void update(String stockTicker, Stock stock){
        stocks.remove(stockTicker);
        stocks.put(stock.getTicker(),stock);
    }

    public void delete(String stockTicker){
        stocks.remove(stockTicker);
    }
}
