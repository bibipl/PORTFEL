package pl.coderslab.equity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquityServiceImpl implements EquityService{

    @Autowired
    EquityRepository equityRepository;

    @Override
    public void save(Equity equity) {
        equityRepository.save(equity);

    }

    @Override
    public void update(Equity equity) {
        equityRepository.save(equity);
    }

    @Override
    public void deleteById(Long id) {
        equityRepository.deleteById(id);
    }

    @Override
    public Equity find(Long id) {
        return equityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equity> findAll() {
        return equityRepository.findAll();
    }
}
