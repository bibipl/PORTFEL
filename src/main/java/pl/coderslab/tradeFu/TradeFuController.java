package pl.coderslab.tradeFu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/trafu")
public class TradeFuController {

    @Autowired
    TradeFutService tradeFutService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<TradeFut> fuTrades = tradeFutService.findAll();
        for (TradeFut tradeFut : fuTrades) {
            double price = tradeFut.getPrice();
            double number = tradeFut.getNumber();
            double multiplier = tradeFut.getFuture().getMutliplier();
            if (number != 0 && price !=0 && multiplier !=0) {
                tradeFut.setExposure(number*price*multiplier);
            }
        }
        model.addAttribute("fuTrades", fuTrades);
        return "showTradesFut";
    }

}
