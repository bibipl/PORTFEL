package pl.coderslab.portfolioFutures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Calculations.Calculator;
import pl.coderslab.futures.Future;
import pl.coderslab.futures.FutureService;
import pl.coderslab.quotFu.QuotFuService;
import pl.coderslab.quotFu.QuotesFut;
import pl.coderslab.tradeFu.TradeFut;
import pl.coderslab.tradeFu.TradeFutService;

import java.time.LocalDate;
import java.util.*;


@Controller
@RequestMapping("/fuFifo")
public class FuFifoController {

    @Autowired
    TradeFutService tradeFutService;

    @Autowired
    QuotFuService quotFuService;

    @Autowired
    FutureService futureService;

    @GetMapping("/calculate")
    public String porfolio (Model model) {
//########### set initial variables ####################

        List<PortfFuture> fuInPortfolio = FutureWholePortfolio(); // We have unique list of not empty future positions in portfolio with all needed data
        PortfFuture totalFuture = FutureTotalPortfolioData (fuInPortfolio); // We have total portfolio calculations

        model.addAttribute("fuPortf", fuInPortfolio);
        model.addAttribute("sum", totalFuture);
        return "showPortfolioFut";
    }

    //##############################################################################################################
    //### Method calculates a future position, that represents whole portfolio, to enable to calculate structure ###
    //### of the portfolio like e.g. % exposure of each future in hte portfolio.                                 ###
    //##############################################################################################################
    private PortfFuture FutureTotalPortfolioData(List<PortfFuture> fuInPortfolio) {
        //fuINPortfolio is filled with right positions
        double totalFuCurrentExposure = 0;
        double totalFuPurchaseExposure = 0 ;

        // Now we count the structure of the portfolio - we need whole portfolio exposure and purchase exposure.
        if (fuInPortfolio != null) {
            for (PortfFuture portfFuture : fuInPortfolio) {
                totalFuCurrentExposure  += portfFuture.getExposure();
                totalFuPurchaseExposure += portfFuture.getPurchaseExposure();
            }
        }

        if (totalFuCurrentExposure != 0) {
            for (PortfFuture portfFuture : fuInPortfolio) {
                double tmpChange = (portfFuture.getExposure() / totalFuCurrentExposure * 100);
                portfFuture.setPercentOfTheExposure(Calculator.round(tmpChange, 2));
            }
        }

        PortfFuture totalFuture = new PortfFuture();
        totalFuture.setName("SUMA");
        totalFuture.setPriceDate(LocalDate.now());
        totalFuture.setExposure(Calculator.round(totalFuCurrentExposure, 2));
        totalFuture.setPurchaseExposure(Calculator.round(totalFuPurchaseExposure, 2));
        if (totalFuPurchaseExposure != 0) { // calculation of change of value o fpositions
            totalFuture.setChangePrice(Calculator.round(((totalFuCurrentExposure / totalFuPurchaseExposure - 1) * 100), 2));
        }
        totalFuture.setChangeValuation(Calculator.round(totalFuCurrentExposure-totalFuPurchaseExposure,2));
        totalFuture.setPercentOfTheExposure(100.00);
        return totalFuture;
    }

    //##############################################################################################################
    //### Method calculates a list of unique names of futures and positions for each of them                     ###
    //### like number in portfolio price etc...                                                                  ###
    //##############################################################################################################
    public  List<PortfFuture> FutureWholePortfolio() {

        List<PortfFuture> fuInPortfolio = new ArrayList<>(); // list of not empty uniqe future positions in portfolio to calculate and return
        List<TradeFut> futureTrades = tradeFutService.findAll(); // to calculate number in portfolio
        List<QuotesFut> futureQuotations = quotFuService.findAll(); // to calculate purchase price.

        // ########### here starts building list of not empty names (open and not closed) in portfolio
        Set<String> futures = new TreeSet<String>();
        for (TradeFut tradeFut : futureTrades) {
            futures.add(tradeFut.getFuture().getName()); // we upload unique names alphabetically
        }
        Iterator<String> itFu = futures.iterator(); // and prepare to take one by one to search transactions

        //######### we take name (one by one) and find all transactions for it
        while (itFu.hasNext()) {
            PortfFuture portfFuture = new PortfFuture();
            List<TradeFut> futureBuy = null;        // list for buys
            List<TradeFut> futureSell = null;       // list for sells
            String name = itFu.next();              // we take the name !!!
            double exposureTaken = 0;                 // final net exposure build value
            long numberBuy = 0;                       // to count # of bought "lots"
            long numberSell = 0;                      // to count # of sold "lots"
            long numberTaken = 0;                      // final net exposure number

        // W find the future (got from transactions) in the future static data of Future class) and fill portfolio position with data
            List<Future> fu = futureService.findByName(name); // we get all data of current future in the portfolio
            if (fu.size() > 0) {                        // when there is at least one future of specified name
                Future fuOne = fu.get(0);               // Then there shuould be exactly one future with the specified, unique name
                portfFuture.setId(fuOne.getId());       // We initiate portfolio position with static data
                portfFuture.setName((fuOne.getName())); // we put static data to display to the portfolio - name of future
                portfFuture.setIsin((fuOne.getIsin())); // we put static data to display to the portfolio - isin of future
                portfFuture.setMultiplier(fuOne.getMultiplier()); // multiplir of the future (eg. x20)

                LocalDate date = null; // we want to find the latest available pricing date
                double price = 0;      // and the latest available price value (from quotes or if not available then from trades)

                //### find the newest quotation date
                //Now we are going to find the latest quotation for specifies future
                if (futureQuotations.size() > 0) { // there can be a situation, when no closing price available in db.
                    for (QuotesFut quoteFut : futureQuotations) {
                        if (quoteFut.getFuture().getName().equals(portfFuture.getName())) {
                            if (date == null) {  // if null we take firs date and price
                                date = quoteFut.getDate();
                                price = quoteFut.getPrice();
                            }
                            if (date.isBefore(quoteFut.getDate())) { // we pick the newest quote date
                                date = quoteFut.getDate();
                                price = quoteFut.getPrice();
                            }
                        }
                    }
                }
// ##### here we should have last quotation pricing value and date. If there was no quotations - we will search trades.
                List<TradeFut> futBuySell = tradeFutService.findAllByFutureIdOrderByTradeDateAsc(fuOne.getId());
                futureBuy = tradeFutService.findTradeFutByTransFutTypeOrderByTradeDateAsc(fuOne.getId(), "KUPNO");
                futureSell = tradeFutService.findTradeFutByTransFutTypeOrderByTradeDateAsc(fuOne.getId(), "SPRZEDAŻ");

// If no quotes availabe (neither date or price=0, we take last available trade price (if there is any => && size >0)
                if ((date == null || price == 0) && (futBuySell.size() > 0)) {
                    date = futBuySell.get(futBuySell.size() - 1).getTradeDate();
                    price = futBuySell.get(futBuySell.size() - 1).getPrice();
                }
// still if no trade price or date available on e.g error or wrong data input, there can be price=0 and date = null

                portfFuture.setPrice(price);        // we fill the portfolio row with current price
                portfFuture.setPriceDate(date);     // we fill the portfolio row with current price date

                //we count overall number futures sold
                for (TradeFut tradeF : futureSell) {
                    numberSell += tradeF.getNumber();
                }

                //we count overall number futures bought
                for (TradeFut tradeF : futureBuy) {
                    numberBuy += tradeF.getNumber();
                }

// now we have all we need to calculate taking position book value

                if (numberBuy > numberSell) {
                    // net "long" position
                    boolean adjusted = false;
                    for (TradeFut tradeB : futureBuy) {
                        if (!adjusted) {
                            if (tradeB.getNumber() >= numberSell) {
                                adjusted = true;
                                double difference = tradeB.getNumber() - numberSell;
                                numberTaken += difference;
                                exposureTaken += difference * tradeB.getPrice() * tradeB.getFuture().getMultiplier();
                                if (numberBuy != 0) {
                                    // we calculate commision as a part of trade that has not been covered by opposite sell trade
                                    exposureTaken += (1 - (double) numberSell / tradeB.getNumber()) * tradeB.getCommision();
                                }
                                else {
                                    exposureTaken += tradeB.getCommision();
                                    numberSell = 0;
                                }
                            } else {
                                numberSell -= tradeB.getNumber();
                            }
                        } else {
                            numberTaken += tradeB.getNumber();
                            exposureTaken += tradeB.getPrice() * tradeB.getNumber() * tradeB.getFuture().getMultiplier() + tradeB.getCommision();
                        }
                    }
                } else if (numberBuy < numberSell) {
                    // net "short" position
                    boolean adjusted = false;
                    for (TradeFut tradeS : futureSell) {
                        if (!adjusted) {
                            if (tradeS.getNumber() >= numberBuy) {
                                adjusted = true;
                                double difference = tradeS.getNumber() - numberBuy;
                                numberTaken -= difference;
                                exposureTaken -= difference * tradeS.getPrice() * tradeS.getFuture().getMultiplier();
                                if (numberSell != 0)
                                    exposureTaken += (1 - (double) numberBuy / tradeS.getNumber()) * tradeS.getCommision(); // part of the commision
                                else {
                                    exposureTaken += tradeS.getCommision(); // the whole commission if no buys
                                    numberBuy = 0;
                                }
                            } else {
                                numberBuy -= tradeS.getNumber();
                            }
                        } else {
                            numberTaken -= tradeS.getNumber();
                            exposureTaken -= tradeS.getPrice() * tradeS.getNumber() * tradeS.getFuture().getMultiplier()
                                    + tradeS.getCommision();
                        }
                    }
                }
                // ### now we fill portfolio position row :
                portfFuture.setNumberOfContracts(numberTaken);
                portfFuture.setPurchaseExposure(Calculator.round(exposureTaken, 2));

                if (numberTaken != 0 && portfFuture.getMultiplier() != 0) {
                    portfFuture.setPurchasePrice(Calculator.round(exposureTaken / numberTaken / portfFuture.getMultiplier(), 2));
                }

                portfFuture.setExposure(Calculator.round(portfFuture.getPrice() * numberTaken * portfFuture.getMultiplier(), 2));
                portfFuture.setChangepts(Calculator.round((portfFuture.getPrice() - portfFuture.getPurchasePrice()), 2));
                portfFuture.setChangeValuation(Calculator.round(portfFuture.getExposure() - portfFuture.getPurchaseExposure(), 2));

                // Complete portfFuture position. The question : do we have <>0 number in portfolio ??
                // if yes, lets update prices and valuations
            }
            fuInPortfolio.add(portfFuture);
        } // end of While iterator - if it end we have all positions in portfolio.
        return (fuInPortfolio);
    }
}
