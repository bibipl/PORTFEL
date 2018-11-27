package pl.coderslab.equity;

import java.util.List;

public interface EquityService {
    public void save (Equity equity);
    public void update (Equity equity);
    public void delete (Equity equity);
    public Equity find (Long id);
    public List<Equity> findAll();

}
