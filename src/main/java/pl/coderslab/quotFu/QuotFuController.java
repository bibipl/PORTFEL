package pl.coderslab.quotFu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.futures.Future;
import pl.coderslab.futures.FutureService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/fuQ")
public class QuotFuController {

    @Autowired
    QuotFuService quotFuService;

    @Autowired
    FutureService futureService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<QuotesFut> quFuts = quotFuService.findAll();
        model.addAttribute("quFuts", quFuts);
        return "showFuturesQuotes";
    }
    @GetMapping("/add")
    public String add(Model model) {
        QuotesFut quotesFut = new QuotesFut();
        quotesFut.setDate(LocalDate.now());
        List<Future> futures = futureService.findAll();
        model.addAttribute("quotesFut", quotesFut);
        model.addAttribute("futures", futures);
        return "addQuotFut";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid QuotesFut quotesFut, BindingResult result) {
        if (result.hasErrors()) {
            return "addQuotFut";
        }
        quotFuService.save(quotesFut);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        quotFuService.deleteById(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        QuotesFut quotesFut = quotFuService.findById(id);
        List<Future> futures = futureService.findAll();
        model.addAttribute("quotesFut", quotesFut);
        model.addAttribute("futures", futures);
        return "addQuotFut";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid QuotesFut quotesFut, BindingResult result) {

        if (result.hasErrors()) {
            return "addQuotFut";
        }
        quotFuService.update(quotesFut);
        return "redirect:../list";
    }
}
