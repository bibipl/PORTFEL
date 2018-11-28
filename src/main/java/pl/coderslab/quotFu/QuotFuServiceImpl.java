package pl.coderslab.quotFu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuotFuServiceImpl implements QuotFuService{

    @Autowired
    QuotFuRepository quotFuRepository;

    @Override
    public void save(QuotesFut quotesFut) {
        quotFuRepository.save(quotesFut);
    }

    @Override
    public void update(QuotesFut quotesFut) {
        quotFuRepository.save(quotesFut);
    }

    @Override
    public void deleteById(Long id) {
        quotFuRepository.deleteById(id);
    }

    @Override
    public QuotesFut findById(Long id) {
        return quotFuRepository.findById(id).orElse(null);
    }

    @Override
    public List<QuotesFut> findAll() {
        return quotFuRepository.findAll();
    }
}
