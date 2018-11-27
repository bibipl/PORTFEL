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

    }

    @Override
    public void update(QuotesFut quotesFut) {

    }

    @Override
    public void delete(QuotesFut quotesFut) {

    }

    @Override
    public QuotesFut find(Long id) {
        return quotFuRepository.getOne(id);
    }

    @Override
    public List<QuotesFut> findAll() {
        return quotFuRepository.findAll();
    }
}
