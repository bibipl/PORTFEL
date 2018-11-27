package pl.coderslab.quotFu;

import pl.coderslab.quotEq.QuotesEqu;

import java.util.List;

public interface QuotFuService {
    public void save (QuotesFut quotesFut);
    public void update (QuotesFut quotesFut);
    public void delete (QuotesFut quotesFut);
    public QuotesFut find (Long id);
    public List<QuotesFut> findAll();
}
