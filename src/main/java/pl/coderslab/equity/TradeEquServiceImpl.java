package pl.coderslab.equity;

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

    }

    @Override
    public void update(TradeEqu tradeEqu) {

    }

    @Override
    public void delete(TradeEqu tradeEqu) {

    }

    @Override
    public TradeEqu find(Long id) {
        return tradeEquRepository.getOne(id);
    }

    @Override
    public List<TradeEqu> findAll() {
        return tradeEquRepository.findAll();
    }
}
