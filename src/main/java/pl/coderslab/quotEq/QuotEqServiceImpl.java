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
        quotEqRepository.save(quotesEqu);
    }

    @Override
    public void update(QuotesEqu quotesEqu) {
        quotEqRepository.save(quotesEqu);
    }

    @Override
    public void deleteById(Long id) {
        quotEqRepository.deleteById(id);
    }

    @Override
    public QuotesEqu findById(Long id) {
        return quotEqRepository.findById(id).orElse(null);
    }

    @Override
    public List<QuotesEqu> findAll() {
        return quotEqRepository.findAll();
    }
}
