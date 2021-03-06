package pl.coderslab.equity;

import java.util.List;

public interface EquityService {
    public void save (Equity equity);
    public void update (Equity equity);
    public void deleteById (Long id);
    public Equity find (Long id);
    public List<Equity> findAll();
    List<Equity> findByIsin(String isin);
    List<Equity> findByName(String name);
}
