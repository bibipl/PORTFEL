package pl.coderslab.tradeFu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.account.Account;
import pl.coderslab.futures.Future;
import pl.coderslab.futures.FutureService;
import pl.coderslab.tradeeq.TradeEqu;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/trafu")
public class TradeFuController {

    @Autowired
    TradeFutService tradeFutService;
    @Autowired
    FutureService futureService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<TradeFut> fuTrades = tradeFutService.findAll();
        for (TradeFut tradeFut : fuTrades) {
            double price = tradeFut.getPrice();
            double number = tradeFut.getNumber();
            double multiplier = tradeFut.getFuture().getMultiplier();
            if (number != 0 && price !=0 && multiplier !=0) {
                tradeFut.setExposure(number*price*multiplier);
            }
        }
        model.addAttribute("fuTrades", fuTrades);
        return "showTradesFut";
    }
    @GetMapping("/add")
    public String add(Model model) {
        LocalDate today = LocalDate.now();
        LocalDate settlDay = today.plusDays(2);
        if (today.getDayOfWeek().name()=="FRIDAY" || today.getDayOfWeek().name()=="THURSDAY") settlDay = today.plusDays(4);
        TradeFut tradeFut = new TradeFut();
        tradeFut.setTradeDate(today);
        tradeFut.setSettlementDate(settlDay);
        List<Future> futures = futureService.findAll();
        model.addAttribute("operFuTypes", tradeFut.operFuTypes);
        model.addAttribute("tradeFut", tradeFut);
        model.addAttribute("futures", futures);
        return "addTradeFut";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid TradeFut tradeFut, BindingResult result) {
        if (result.hasErrors()) {
            return "addTradeFut";
        }
        tradeFutService.save(tradeFut);
        return "redirect:/trafu/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        tradeFutService.deleteById(id);
        return "redirect:/trafu/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        TradeFut tradeFut = tradeFutService.findById(id);
        List<Future> futures = futureService.findAll();
        model.addAttribute("operFuTypes", tradeFut.operFuTypes);
        model.addAttribute("tradeFut", tradeFut);
        model.addAttribute("futures", futures);
        return "addTradeFut";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid TradeFut tradeFut, BindingResult result) {

        if (result.hasErrors()) {
            return "addTradeFut";
        }
        tradeFutService.update(tradeFut);
        return "redirect:/trafu/list";
    }
    @GetMapping("/histid/{id}")
    public String tradeHistoryById (Model model, @PathVariable Long id) {
        List<TradeFut> fuTrades = tradeFutService.findAllByFutureIdOrderByTradeDateAsc(id);
        model.addAttribute("fuTrades", fuTrades);
        return"showTradesFut";
    }

}
