package pl.coderslab.quotEq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.equity.Equity;
import pl.coderslab.equity.EquityService;
import pl.coderslab.operAcc.OperAcc;
import pl.coderslab.tradeeq.TradeEqu;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/eqQ")
public class QuotEqController {

    @Autowired
    QuotEqService quotEqService;

    @Autowired
    EquityService equityService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<QuotesEqu> quEqs = quotEqService.findAll();
        model.addAttribute("quEqs", quEqs);
        return "showEquityQuotes";
    }
    @GetMapping("/add")
    public String add(Model model) {
        QuotesEqu quotesEqu = new QuotesEqu();
        quotesEqu.setDate(LocalDate.now());
        List<Equity> equities = equityService.findAll();
        model.addAttribute("quotesEqu", quotesEqu);
        model.addAttribute("equities", equities);
        return "addQuotEqu";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid QuotesEqu quotesEqu, BindingResult result) {
        if (result.hasErrors()) {
            return "addQuotEqu";
        }
        quotEqService.save(quotesEqu);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        quotEqService.deleteById(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        QuotesEqu quotesEqu = quotEqService.findById(id);
        List<Equity> equities = equityService.findAll();
        model.addAttribute("quotesEqu", quotesEqu);
        model.addAttribute("equities", equities);
        return "addQuotEqu";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid QuotesEqu quotesEqu, BindingResult result) {

        if (result.hasErrors()) {
            return "addQuotEqu";
        }
        quotEqService.update(quotesEqu);
        return "redirect:../list";
    }
}
