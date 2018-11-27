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

    }

    @Override
    public void update(TradeFut tradeFut) {

    }

    @Override
    public void delete(TradeFut tradeFut) {

    }

    @Override
    public TradeFut find(Long id) {
        return tradeFutRepository.getOne(id);
    }

    @Override
    public List<TradeFut> findAll() {
        return tradeFutRepository.findAll();
    }
}
