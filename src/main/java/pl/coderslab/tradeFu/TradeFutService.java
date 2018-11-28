package pl.coderslab.tradeFu;

import java.util.List;

public interface TradeFutService {
    public void save (TradeFut tradeFut);
    public void update (TradeFut tradeFut);
    public void deleteById (Long id);
    public TradeFut findById (Long id);
    public List<TradeFut> findAll();
}
