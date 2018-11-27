package pl.coderslab.quotEq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuotEqServiceImpl implements QuotEqService {

    @Autowired
    QuotEqRepository quotEqRepository;

    @Override
    public void save(QuotesEqu quotesEqu) {

    }

    @Override
    public void update(QuotesEqu quotesEqu) {

    }

    @Override
    public void delete(QuotesEqu quotesEqu) {

    }

    @Override
    public QuotesEqu find(Long id) {
        return quotEqRepository.getOne(id);
    }

    @Override
    public List<QuotesEqu> findAll() {
        return quotEqRepository.findAll();
    }
}
