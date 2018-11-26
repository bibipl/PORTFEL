package pl.coderslab.equity;

import javax.persistence.*;

@Entity
@Table(name = "EQUITIES")
public class Equity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String isin;

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

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }
}
