package pl.coderslab.tradeFu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TradeFutServiceImpl implements TradeFutService {

    @Autowired
    TradeFutRepository tradeFutRepository;

    @Override
    public void save(TradeFut tradeFut) {
        tradeFutRepository.save(tradeFut);

    }

    @Override
    public void update(TradeFut tradeFut) {
        tradeFutRepository.save(tradeFut);
    }

    @Override
    public void deleteById(Long id) {
        tradeFutRepository.deleteById(id);
    }

    @Override
    public TradeFut findById(Long id) {
        return tradeFutRepository.findById(id).orElse(null);
    }

    @Override
    public List<TradeFut> findAll() {
        return tradeFutRepository.findAll();
    }
}
