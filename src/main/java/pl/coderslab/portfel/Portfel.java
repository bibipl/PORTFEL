package pl.coderslab.portfel;

import pl.coderslab.account.Account;
import pl.coderslab.equity.Equity;
import pl.coderslab.futures.Future;

import java.time.LocalDate;
import java.util.List;

public class Portfel {
    private LocalDate valuationDate;
    private List<Equity> equities;
    private List<Future> futures;
    private List<Account> accounts;

    public Portfel() {
    }

    public LocalDate getValuationDate() {
        return valuationDate;
    }

    public void setValuationDate(LocalDate valuationDate) {
        this.valuationDate = valuationDate;
    }

    public List<Equity> getEquities() {
        return equities;
    }

    public void setEquities(List<Equity> equities) {
        this.equities = equities;
    }

    public List<Future> getFutures() {
        return futures;
    }

    public void setFutures(List<Future> futures) {
        this.futures = futures;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
