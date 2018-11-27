package pl.coderslab.portfel;

import pl.coderslab.account.Account;
import pl.coderslab.equity.Equity;
import pl.coderslab.futures.Future;

import java.time.LocalDate;
import java.util.List;

public class Portfel {
    private LocalDate valuationDate;
    private List<Equity> equities;
    private double eqNumber;
    private double eqPurchaseValue;
    private double eqTotalValue;

    private List<Future> futures;
    private double fuNumber;
    private double fuPurchaseValue;
    private double fuTotalValue;

    private List<Account> accounts;
    private double acNumber;
    private double acPurchaseValue;
    private double acTotalValue;
    private double totalNumber;
    private double totalPurchaseValue;
    private double totalValue;

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

    public double getEqNumber() {
        return eqNumber;
    }

    public void setEqNumber(double eqNumber) {
        this.eqNumber = eqNumber;
    }

    public double getEqPurchaseValue() {
        return eqPurchaseValue;
    }

    public void setEqPurchaseValue(double eqPurchaseValue) {
        this.eqPurchaseValue = eqPurchaseValue;
    }

    public double getEqTotalValue() {
        return eqTotalValue;
    }

    public void setEqTotalValue(double eqTotalValue) {
        this.eqTotalValue = eqTotalValue;
    }

    public List<Future> getFutures() {
        return futures;
    }

    public void setFutures(List<Future> futures) {
        this.futures = futures;
    }

    public double getFuNumber() {
        return fuNumber;
    }

    public void setFuNumber(double fuNumber) {
        this.fuNumber = fuNumber;
    }

    public double getFuPurchaseValue() {
        return fuPurchaseValue;
    }

    public void setFuPurchaseValue(double fuPurchaseValue) {
        this.fuPurchaseValue = fuPurchaseValue;
    }

    public double getFuTotalValue() {
        return fuTotalValue;
    }

    public void setFuTotalValue(double fuTotalValue) {
        this.fuTotalValue = fuTotalValue;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public double getAcNumber() {
        return acNumber;
    }

    public void setAcNumber(double acNumber) {
        this.acNumber = acNumber;
    }

    public double getAcPurchaseValue() {
        return acPurchaseValue;
    }

    public void setAcPurchaseValue(double acPurchaseValue) {
        this.acPurchaseValue = acPurchaseValue;
    }

    public double getAcTotalValue() {
        return acTotalValue;
    }

    public void setAcTotalValue(double acTotalValue) {
        this.acTotalValue = acTotalValue;
    }

    public double getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(double totalNumber) {
        this.totalNumber = totalNumber;
    }

    public double getTotalPurchaseValue() {
        return totalPurchaseValue;
    }

    public void setTotalPurchaseValue(double totalPurchaseValue) {
        this.totalPurchaseValue = totalPurchaseValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
