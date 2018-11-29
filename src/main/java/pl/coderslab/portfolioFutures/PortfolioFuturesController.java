package pl.coderslab.portfolioFutures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Calculator;
import pl.coderslab.quotFu.QuotFuService;
import pl.coderslab.quotFu.QuotesFut;
import pl.coderslab.tradeFu.TradeFut;
import pl.coderslab.tradeFu.TradeFutService;

import java.time.LocalDate;
import java.util.*;


@Controller
@RequestMapping("/fuPortf")
public class PortfolioFuturesController {


    @Autowired
    TradeFutService tradeFutService;

    @Autowired
    QuotFuService quotFuService;


    @GetMapping("/calculate")
    public String porfolio(Model model) {
        double totalFuCurrentExp = 0;   // we need it to calculate later structure of the equity portfolio (val/totalVal)
        double totatFuPurchaseExp = 0;

        List<TradeFut> futureTrades = tradeFutService.findAll();
        List<QuotesFut> futureQuotations = quotFuService.findAll();

        List<PortfFuture> fuInPortfolio = new ArrayList<>();


        Set<String> futures = new TreeSet<String>();
        for (TradeFut tradeFut : futureTrades) {
            futures.add(tradeFut.getFuture().getIsin()); // we upload uniqe isins to search transactions
        }
        Iterator<String> itFu = futures.iterator();

        while (itFu.hasNext()) {
            PortfFuture portfFuture = new PortfFuture();
            portfFuture.setIsin(itFu.next());
            LocalDate date = null;
            double price = 0;

            //Now we are going to find the latest quotation for sppecifies equity
            if (futureQuotations.size() > 0) {
                for (QuotesFut quotesFut : futureQuotations) {
                    if (quotesFut.getFuture().getIsin().equals(portfFuture.getIsin())) {
                        portfFuture.setName(quotesFut.getFuture().getName());       // static Future data into portfFut
                        portfFuture.setMultiplier(quotesFut.getFuture().getMultiplier()); // static data
                        if (date == null) {
                            date = quotesFut.getDate();
                            price = quotesFut.getPrice();
                        }
                        if (!date.isAfter(quotesFut.getDate())) {
                            // in case we have to replace todays trade price with todays quotation
                            // dates equal but we prefer closing price
                            date = quotesFut.getDate();
                            price = quotesFut.getPrice();
                        }
                    }
                }
                portfFuture.setPriceDate(date);  // current date
                portfFuture.setPrice(price);      // current price
            }
            // Here if price <>0 and date<>null we got last quotation and last date
            // Now we look for number of shares and purchase price

            if (futureTrades.size() > 0) {
                double exposure = 0;
                long number = 0;
                double commision = 0;
                for (TradeFut tradeFut : futureTrades) {
                    // below : if to take only propoer equity (by isin we reconize)
                    if (tradeFut.getFuture().getIsin().equals(portfFuture.getIsin())) {
                        if (tradeFut.getTransFutType().equals("KUPNO")) {
                            number += tradeFut.getNumber();
                            exposure += tradeFut.getNumber() * tradeFut.getPrice()*tradeFut.getFuture().getMultiplier();
                            commision += tradeFut.getCommision();
                        } else if (tradeFut.getTransFutType().equals("SPRZEDAŻ")) {
                            number -= tradeFut.getNumber();
                            exposure -= tradeFut.getNumber() * tradeFut.getPrice()*tradeFut.getFuture().getMultiplier();
                            commision += tradeFut.getCommision();
                        }
                        // below price and date - we update to keep last's transaction curent data,
                        // in case there is no quotation in the database yet
                        if (portfFuture.getPrice() == 0) portfFuture.setPrice(tradeFut.getPrice());
                        if (portfFuture.getPriceDate() == null)
                            portfFuture.setPriceDate(tradeFut.getTradeDate());
                        if (number == 0) exposure = 0; // position closed completely = we start to count from 0;
                    }
                } // for
                portfFuture.setPurchaseExposure(Calculator.round(exposure,2));
                portfFuture.setNumberOfContracts(number);
                if (number != 0) portfFuture.setPurchasePrice(Calculator.round(exposure / number /20,2));
                else portfFuture.setPurchasePrice(0.00);
            } // finished one equity search, before next loop lets calculate avg prices etc....

            if (portfFuture.getPurchasePrice() != 0) {
                double tmpChange = (portfFuture.getPrice() / portfFuture.getPurchasePrice() - 1) * 100;
                portfFuture.setChangePrice(Calculator.round(tmpChange,2));
            }
            double exposure = portfFuture.getPrice() * portfFuture.getNumberOfContracts()*portfFuture.getMultiplier();
            portfFuture.setExposure(Calculator.round(exposure,2));

            if (portfFuture.getPurchaseExposure() != 0) {
                double tmpChange = portfFuture.getExposure() - portfFuture.getPurchaseExposure();
                portfFuture.setChangeValuation(Calculator.round(tmpChange,2));
            }
            portfFuture.setChangepts(portfFuture.getPrice() - portfFuture.getPurchasePrice());
            totalFuCurrentExp  += portfFuture.getExposure();
            totatFuPurchaseExp += portfFuture.getPurchaseExposure();
            fuInPortfolio.add(portfFuture);
        } // end of While iterator

        // Now we count the structure of the portfolio
        if (totalFuCurrentExp!= 0) {
            for (PortfFuture portfFuture : fuInPortfolio) {
                double tmpChange = (portfFuture.getExposure() / totalFuCurrentExp * 100);
                portfFuture.setPercentOfTheExposure(Calculator.round(tmpChange,2));
            }
        }
        PortfFuture totalFuture = new PortfFuture();
        totalFuture.setName("SUMA");
        totalFuture.setPriceDate(LocalDate.now());
        totalFuture.setExposure(Calculator.round(totalFuCurrentExp,2));
        totalFuture.setPurchaseExposure(Calculator.round(totatFuPurchaseExp,2));
        if (totatFuPurchaseExp != 0 ) {
            double tmpChange =(totalFuCurrentExp-totatFuPurchaseExp);
            totalFuture.setChangeValuation(Calculator.round(tmpChange,2));
        }
        totalFuture.setPercentOfTheExposure(100.00);
        model.addAttribute("fuPortf", fuInPortfolio);
        model.addAttribute("sum", totalFuture);
        return "showPortfolioFut";
    }

}
