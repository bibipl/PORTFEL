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

    }

    @Override
    public void update(Equity equity) {

    }

    @Override
    public void delete(Equity equity) {

    }

    @Override
    public Equity find(Long id) {
        return equityRepository.getOne(id);
    }

    @Override
    public List<Equity> findAll() {
        return equityRepository.findAll();
    }
}
