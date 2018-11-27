package pl.coderslab.equity;

import java.util.List;

public interface TradeEquService {
    public void save (TradeEqu tradeEqu);
    public void update (TradeEqu tradeEqu);
    public void delete (TradeEqu tradeEqu);
    public TradeEqu find (Long id);
    public List<TradeEqu> findAll();
}

