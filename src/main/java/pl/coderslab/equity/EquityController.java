package pl.coderslab.equity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/equ")
public class EquityController {

    @Autowired
    private EquityService equityService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Equity> equities = equityService.findAll();
        for (Equity equity : equities) {
            equity.setPriceDate(LocalDate.now());
        }
        model.addAttribute("equities", equities);
        return "showEquities";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Equity equity = new Equity();
        model.addAttribute("equity", equity);
        return "addEquity";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute @Valid Equity equity, BindingResult result) {
        if (result.hasErrors()) {
            return "addEquity";
        }
        equityService.save(equity);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        equityService.deleteById(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Equity equity = equityService.find(id);
        model.addAttribute("equity", equity);
        return "addEquity";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute @Valid Equity equity, BindingResult result) {

        if (result.hasErrors()) {
            return "addEquity";
        }
        equityService.update(equity);
        return "redirect:../list";
    }
}






