package pl.coderslab.futures;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.account.Account;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "FUTURES")
public class Future {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String isin;
    private double multiplier;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    private String description;
    @OneToOne
    private Account account;            // !!! to update valuation we need account account.

    @Transient
    private double price;               // temporary keeps last available price
    @Transient
    private LocalDate priceDate;        // temporary keeps date of last available price
    @Transient
    private double numberOfContracts;   // temporary keeps last number of shares
    @Transient
    private double exposure;

    public Future() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(LocalDate priceDate) {
        this.priceDate = priceDate;
    }

    public double getNumberOfContracts() {
        return numberOfContracts;
    }

    public void setNumberOfContracts(double numberOfContracts) {
        this.numberOfContracts = numberOfContracts;
    }

    public double getExposure() {
        return exposure;
    }

    public void setExposure(double exposure) {
        this.exposure = exposure;
    }

}
