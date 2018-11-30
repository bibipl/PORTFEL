package pl.coderslab.tradeeq;

import java.util.List;

public interface TradeEquService {
    public void save (TradeEqu tradeEqu);
    public void update (TradeEqu tradeEqu);
    public void deleteById (Long id);
    public TradeEqu findById (Long id);
    public List<TradeEqu> findAll();
    List<TradeEqu> findAllByEquityId (Long id);
    List<TradeEqu> findTradeEquByTransEquType(Long id, String transEquType);
}

