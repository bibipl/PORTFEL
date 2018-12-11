package pl.coderslab.equity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EQUITIES")
public class Equity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String isin;           // uniqe official number
    @NotBlank
    private String name;
    private  String description;


    @Transient
    private double price;           // temporary keeps last available price
    @Transient
    private LocalDate priceDate;       // temporary keeps date of last available price
    @Transient
    private Long numberOfShares;    // temporary keeps last number of shares
    @Transient
    private double value;
    public Equity() {

    }

    public Equity(String name, String isin) {
        this.name = name;
        this.isin = isin;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
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

    public Long getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Long numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
