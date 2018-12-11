package pl.coderslab.futures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.account.Account;
import pl.coderslab.account.AccountService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/fut")
public class FutureController {

    @Autowired
    private FutureService futureService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Future> futures = futureService.findAll();
        for (Future future : futures) {
            future.setPriceDate(LocalDate.now());
        }
        model.addAttribute("futures", futures);
        return "showFutures";
    }
    @GetMapping("/add")
    public String add(Model model) {
        Future future = new Future();
        List <Account> accounts = accountService.findAll();
        model.addAttribute("future", future);
        model.addAttribute("accounts", accounts);
        return "addFuture";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid Future future, BindingResult result) {
        if (result.hasErrors()) {
            return "addFuture";
        }
        futureService.save(future);
        return "redirect:/fut/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        futureService.deleteById(id);
        return "redirect:/fut/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Future future = futureService.find(id);
        List <Account> accounts = accountService.findAll();
        model.addAttribute("future", future);
        model.addAttribute("accounts", accounts);
        return "addFuture";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid Future future, BindingResult result) {

        if (result.hasErrors()) {
            return "addFuture";
        }
        futureService.update(future);
        return "redirect:/fut/list";
    }

}
