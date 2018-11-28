package pl.coderslab.tradeeq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.equity.Equity;
import pl.coderslab.equity.EquityService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/traeq")
public class TradeEquController {

    @Autowired
    TradeEquService tradeEquService;

    @Autowired
    EquityService equityService;

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
    @GetMapping("/add")
    public String add(Model model) {
        LocalDate today = LocalDate.now();
        LocalDate settlDay = today.plusDays(2);
        if (today.getDayOfWeek().name()=="FRIDAY") settlDay = today.plusDays(4);
        TradeEqu tradeEqu = new TradeEqu();
        tradeEqu.setTradeDate(today);
        tradeEqu.setSettlementDate(settlDay);
        List<Equity> equities = equityService.findAll();
        model.addAttribute("operEqTypes", tradeEqu.operEqTypes);
        model.addAttribute("tradeEqu", tradeEqu);
        model.addAttribute("equities", equities);
        return "addTradEqu";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid TradeEqu tradeEqu, BindingResult result) {
        if (result.hasErrors()) {
            return "addTradEqu";
        }
        tradeEquService.save(tradeEqu);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        tradeEquService.deleteById(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        TradeEqu tradeEqu = tradeEquService.findById(id);
        List<Equity> equities = equityService.findAll();
        model.addAttribute("operEqTypes", tradeEqu.operEqTypes);
        model.addAttribute("tradeEqu", tradeEqu);
        model.addAttribute("equities", equities);
        return "addTradEqu";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid TradeEqu tradeEqu, BindingResult result) {

        if (result.hasErrors()) {
            return "addTradEqu";
        }
        tradeEquService.update(tradeEqu);
        return "redirect:../list";
    }
}
