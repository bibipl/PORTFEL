package pl.coderslab.tradeeq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/traeq")
public class TradeEquController {

    @Autowired
    TradeEquService tradeEquService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<TradeEqu> eqTrades = tradeEquService.findAll();
        for (TradeEqu tradeEqu : eqTrades) {
            double price = tradeEqu.getPrice();
            double number = tradeEqu.getNumber();
            if (number != 0 && price !=0) {
                tradeEqu.setValue(number*price);
            }
        }
        model.addAttribute("eqTrades", eqTrades);
        return "showTradesEqu";
    }
}