package pl.coderslab.tradeeq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TradeEquServiceImpl implements TradeEquService {

    @Autowired
    TradeEquRepository tradeEquRepository;

    @Override
    public void save(TradeEqu tradeEqu) {
        tradeEquRepository.save(tradeEqu);
    }

    @Override
    public void update(TradeEqu tradeEqu) {
        tradeEquRepository.save(tradeEqu);
    }

    @Override
    public void deleteById(Long id) {
        tradeEquRepository.deleteById(id);
    }

    @Override
    public TradeEqu findById(Long id) {
        return tradeEquRepository.findById(id).orElse(null);
    }

    @Override
    public List<TradeEqu> findAll() {
        return tradeEquRepository.findAll();
    }
}
