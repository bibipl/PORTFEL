package pl.coderslab.operAcc;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.account.Account;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name ="OPERATIONS_ACCOUNT")
public class OperAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate tradeDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate settlementDate;
    private double value;
    private double commision;
    private String description;

    @ManyToOne
    private Account account;

    /*@Enumerated(EnumType.STRING)*/
    @Column(length = 10)
    String operAccType;

    @Transient
    List<String> operTypes = new ArrayList<>(Arrays.asList("WPŁATA", "WYPŁATA", "KOREKTA", "ODSETKI", "SALDO"));
    /*public enum OperAccType {
        WPŁATA, WYPŁATA, KOREKTA, ODSETKI, SALDO
    }*/

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

    public String getOperAccType() {
        return operAccType;
    }

    public void setOperAccType(String operAccType) {
        this.operAccType = operAccType;
    }
}
