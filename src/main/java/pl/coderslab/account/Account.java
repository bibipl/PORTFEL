package pl.coderslab.account;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // id to database
    private String Name;    // name of the account
    @Transient
    private double value;   // value of the account not ot store in db
    @Transient
    private double partOfTotalCash;
    @Transient
    private LocalDate date; // date of last transaction
    private String description; // small optional info

    public Account() {      // we need only empty - all values by set/get
    }

    public Account(String name) {
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPartOfTotalCash() {
        return partOfTotalCash;
    }

    public void setPartOfTotalCash(double partOfTotalCash) {
        this.partOfTotalCash = partOfTotalCash;
    }
}
