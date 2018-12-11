package pl.coderslab.portfolioEquity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Calculations.Calculator;
import pl.coderslab.equity.Equity;
import pl.coderslab.equity.EquityService;
import pl.coderslab.quotEq.QuotEqService;
import pl.coderslab.quotEq.QuotesEqu;
import pl.coderslab.tradeeq.TradeEqu;
import pl.coderslab.tradeeq.TradeEquService;


import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/eqPortf")
public class PortfolioEquityController {

    @Autowired
    TradeEquService tradeEquService;

    @Autowired
    QuotEqService quotEqService;

    @Autowired
    EquityService equityService;

    @GetMapping("/calculate")
    public String porfolio(Model model) {

        double totalEqCurrentValue = 0;   // we need it to calculate later structure of the equity portfolio (val/totalVal)
        double totalEqPurchaseValue = 0;

        List<PortfEquity> eqInPortfolio = new ArrayList<>();
        List<TradeEqu> equityTrades = tradeEquService.findAll();
        List<QuotesEqu> equityQuotations = quotEqService.findAll();

        Set<String> equities = new TreeSet<String>();
        for (TradeEqu tradeEqu : equityTrades) {
            equities.add(tradeEqu.getEquity().getName()); // we upload names alphabetically
        }
        Iterator<String> itEq = equities.iterator();

        while (itEq.hasNext()) {
            PortfEquity portfEquity = new PortfEquity();
            List<TradeEqu> equityBuy = null;
            List<TradeEqu> equitySell = null;
            String name = itEq.next();
            double valueBuy =0;
            long numberBuy=0;
            long numberSell=0;
            List<Equity> eq = equityService.findByName(name);
            if (eq.size() > 0) {    // when there is at least one equity

                Equity eqOne = eq.get(0);               // There shuould be exactly one equity
                portfEquity.setId(eqOne.getId());       // We initiate portfolio position with static data
                portfEquity.setName((eqOne.getName()));
                portfEquity.setIsin(eqOne.getIsin());

                LocalDate date = null;
                double price = 0;

                //### find the newest quotatioin date
                //Now we are going to find the latest quotation for specifies equity
                if (equityQuotations.size() > 0) {
                    for (QuotesEqu quotesEqu : equityQuotations) {
                        if (quotesEqu.getEquity().getName().equals(portfEquity.getName())) {
                            if (date == null) {
                                date = quotesEqu.getDate();
                                price = quotesEqu.getPrice();
                            }
                            if (!date.isAfter(quotesEqu.getDate())) {
                                // in case we have to replace todays trade price with todays quotation
                                // dates may be equal but we prefer closing price
                                date = quotesEqu.getDate();
                                price = quotesEqu.getPrice();
                            }
                        }
                    }
                    portfEquity.setCurrentValuationDate(date);
                    portfEquity.setCurrentPrice(Calculator.round(price, 2));
                }
                // ### Static + price value/date ok.
                // Here if price <>0 and date<>null we got last quotation and last date
                // Now we look for number of shares and purchase price

                equityBuy = tradeEquService.findTradeEquByTransEquType(eqOne.getId(), "KUPNO");
                equitySell = tradeEquService.findTradeEquByTransEquType(eqOne.getId(), "SPRZEDAŻ");

                //we count overall number equities sold
                for (TradeEqu tradeS : equitySell) {
                    numberSell += tradeS.getNumber();
                }
                // we count overall number bought and value bought subtr. FIFO sold ones
                boolean adjusted = false;
                for (TradeEqu tradeB : equityBuy) {
                    if (!adjusted) {
                        if (tradeB.getNumber() >= numberSell) {
                            adjusted = true;
                            double difference = tradeB.getNumber() - numberSell;
                            numberBuy += difference;
                            valueBuy += difference * tradeB.getPrice();
                            if (numberSell > 0) valueBuy += difference / numberSell * tradeB.getCommision();
                            else valueBuy += tradeB.getCommision();
                        } else {
                            numberSell -= tradeB.getNumber();
                        }
                    } else {
                        numberBuy += tradeB.getNumber();
                        valueBuy += tradeB.getPrice() * tradeB.getNumber() + tradeB.getCommision();
                    }
                }
                // here now we have calculated number of shares remaining in the portfolio and purchase value of the shares
                portfEquity.setNumber(numberBuy);
                //portfEquity.setValue(Calculator.round(valueBuy, 2));
                if (numberBuy != 0) {
                    double purchasePrice = Calculator.round(valueBuy / numberBuy, 2);
                    portfEquity.setPurchasePrice(purchasePrice);
                    portfEquity.setPurchaseValuation(Calculator.round(purchasePrice * numberBuy, 2));
                    portfEquity.setCurrentValuation(Calculator.round(portfEquity.getCurrentPrice()*numberBuy,2));
                    if (purchasePrice != 0) {
                        portfEquity.setChangePrice(Calculator.round((portfEquity.getCurrentPrice()/portfEquity.getPurchasePrice()-1)*100,2));
                    }
                    portfEquity.setChangeValuation(Calculator.round(portfEquity.getCurrentValuation() - portfEquity.getPurchaseValuation(),2));
                }
                // Complete portfEquity position. The question : do we have <>0 number in portfolio ??
                // if yes, lets update prices and valuations
                if (numberBuy != 0) {
                    eqInPortfolio.add(portfEquity);
                    totalEqPurchaseValue += portfEquity.getPurchaseValuation();
                    totalEqCurrentValue += portfEquity.getCurrentValuation();

                }
            }
        } // end of While iterator

        // Now we count the structure of the portfolio
        if (totalEqCurrentValue != 0) {
            for (PortfEquity portfEquity : eqInPortfolio) {
                double tmpChange = (portfEquity.getCurrentValuation() / totalEqCurrentValue * 100);
                portfEquity.setPercenOfThePortfolio(Calculator.round(tmpChange, 2));
            }
        }
        PortfEquity totalEquity = new PortfEquity();
        totalEquity.setName("SUMA");
        totalEquity.setCurrentValuationDate(LocalDate.now());
        totalEquity.setCurrentValuation(Calculator.round(totalEqCurrentValue, 2));
        totalEquity.setPurchaseValuation(Calculator.round(totalEqPurchaseValue, 2));
        if (totalEqPurchaseValue != 0) {
            double tmpChange = (totalEqCurrentValue / totalEqPurchaseValue - 1) * 100;
            totalEquity.setChangePrice(Calculator.round(tmpChange, 2));
        }
        totalEquity.setChangeValuation(Calculator.round(totalEqCurrentValue-totalEqPurchaseValue,2));
        totalEquity.setPercenOfThePortfolio(100.00);

        model.addAttribute("eqPortf", eqInPortfolio);
        model.addAttribute("sum", totalEquity);
        return "showPortfolioEqu";
    }
}
