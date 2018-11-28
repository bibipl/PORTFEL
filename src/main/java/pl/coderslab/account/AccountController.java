package pl.coderslab.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "showAccounts";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "addAccount";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "addAccount";
        }
        accountService.save(account);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        accountService.deleteById(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Account account = accountService.find(id);
        model.addAttribute("account", account);
        return "addAccount";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid Account account, BindingResult result) {

        if (result.hasErrors()) {
            return "addAccount";
        }
        accountService.update(account);
        return "redirect:../list";
    }
}
