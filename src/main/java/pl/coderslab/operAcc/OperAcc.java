package pl.coderslab.operAcc;

import pl.coderslab.account.Account;
import pl.coderslab.tradeeq.TradeEqu;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="OPERATIONS_ACCOUNT")
public class OperAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDate tradeDate;
    LocalDate settlementDate;
    private double value;
    private double commision;
    private String description;

    @ManyToOne
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    OperAccType operAccType;

    public enum OperAccType {
        WPŁATA, WYPŁATA, KOREKTA, ODSETKI, SALDO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public OperAccType getOperAccType() {
        return operAccType;
    }

    public void setOperAccType(OperAccType operAccType) {
        this.operAccType = operAccType;
    }
}
