package pl.coderslab.futures;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "FUTURES")
public class Future {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String isin;
    private int mutliplier;
    private LocalDate expirationDate;
    private Long cashId; // !!! to spdate valuation we need account account.

    public Future() {
    }

    public Future(String name, String isin, int mutliplier, LocalDate expirationDate, Long cashId) {
        this.name = name;
        this.isin = isin;
        this.mutliplier = mutliplier;
        this.expirationDate = expirationDate;
        this.cashId = cashId;
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

    public int getMutliplier() {
        return mutliplier;
    }

    public void setMutliplier(int mutliplier) {
        this.mutliplier = mutliplier;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getCashId() {
        return cashId;
    }

    public void setCashId(Long cashId) {
        this.cashId = cashId;
    }
}
