package pl.coderslab.quotFu;

import pl.coderslab.quotEq.QuotesEqu;

import java.util.List;

public interface QuotFuService {
    public void save (QuotesFut quotesFut);
    public void update (QuotesFut quotesFut);
    public void deleteById (Long id);
    public QuotesFut findById (Long id);
    public List<QuotesFut> findAll();
}
