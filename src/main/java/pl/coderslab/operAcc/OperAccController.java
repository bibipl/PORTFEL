package pl.coderslab.operAcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.account.Account;
import pl.coderslab.account.AccountService;
import pl.coderslab.tradeFu.TradeFut;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/opacc")
public class OperAccController {

    @Autowired
    OperAccService operAccService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<OperAcc> operAccs = operAccService.findAll();
        model.addAttribute("operAccs", operAccs);
        return "showOperAcc";
    }
    @GetMapping("/add")
    public String add(Model model) {
        OperAcc operacc = new OperAcc();
        operacc.setTradeDate(LocalDate.now());
        operacc.setSettlementDate(LocalDate.now());
        List<Account> accounts = accountService.findAll();
        model.addAttribute("operTypes", operacc.operTypes);
        model.addAttribute("operacc", operacc);
        model.addAttribute("accounts", accounts);
        return "addOperAcc";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid OperAcc operacc, BindingResult result) {
        if (result.hasErrors()) {
            return "addOperAcc";
        }
        operAccService.save(operacc);
        return "redirect:/opacc/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        operAccService.deleteById(id);
        return "redirect:/opacc/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        OperAcc operacc = operAccService.find(id);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("operTypes", operacc.operTypes);
        model.addAttribute("operacc", operacc);
        model.addAttribute("accounts", accounts);
        return "addOperAcc";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid OperAcc operacc, BindingResult result) {

        if (result.hasErrors()) {
            return "addOperAcc";
        }
        operAccService.update(operacc);
        return "redirect:/opacc/list";
    }
    @GetMapping("/histid/{id}")
    public String tradeHistoryById (Model model, @PathVariable Long id) {
        List<OperAcc> operAccs = operAccService.findAllByAccountId(id);
        model.addAttribute("operAccs", operAccs);
        return"showOperAcc";
    }
}
