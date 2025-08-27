package lll.whobuys.stock;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {
    StockService stockService;
    StockCRUDService stockCRUDService;

    @Autowired
    StockController(StockService stockService, StockCRUDService stockCRUDService) {
        this.stockService = stockService;
        this.stockCRUDService = stockCRUDService;
    }

    @GetMapping
    public String stocks(Model model) {
        List<Stock>stocks = stockCRUDService.getAllStocks();
        model.addAttribute("stocks", stocks);
        return "stock/stocks";
    }

    @GetMapping("/add")
    public String addStockForm(Model model) {
        model.addAttribute(new Stock(null,null,null,null,null));
        return "stock/stockAddForm";
    }

    @PostMapping("/add")
    public String addStock(@ModelAttribute("stock") Stock stock) {
        stockCRUDService.addStock(stock);
        return "redirect:/stock";
    }

    @GetMapping("/{stockTicker}")
    public String stockDetail(@PathVariable String stockTicker, Model model) {
        Stock stock = stockCRUDService.getStockByTicker(stockTicker);
        model.addAttribute("stock", stock);
        if(stockService.highPriceEarningRatioStock(stock)){
            model.addAttribute("highPER",true);
        }
        return "stock/stockDetailForm";
    }

    @GetMapping("/{stockTicker}/edit")
    public String editStockForm(@PathVariable String stockTicker, Model model) {
        Stock stock = stockCRUDService.getStockByTicker(stockTicker);
        model.addAttribute("stock", stock);
        return "stock/stockUpdateForm";
    }

    @PostMapping("/{stockTicker}/edit")
    public String editStock(@ModelAttribute("stock") Stock stock, @PathVariable String stockTicker) {
        stockCRUDService.updateStock(stockTicker,stock);
        return "redirect:/stock";
    }

    @PostMapping("/{stockTicker}/delete")
    public String deleteStock(@PathVariable String stockTicker) {
        stockCRUDService.deleteStock(stockTicker);
        return "redirect:/stock";
    }

    @PostConstruct
    public void init() {
        stockCRUDService.addStock(new Stock("AAPL","Apple Inc.",229.93,30.25,14000000000L));
        stockCRUDService.addStock(new Stock("PLTR","Panlantir Technologies",157.23,400.25,2000000000L));
    }
}