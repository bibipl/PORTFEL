package pl.coderslab.quotEq;


import java.util.List;

public interface QuotEqService {
    public void save (QuotesEqu quotesEqu);
    public void update (QuotesEqu quotesEqu);
    public void delete (QuotesEqu quotesEqu);
    public QuotesEqu find (Long id);
    public List<QuotesEqu> findAll();
}
