package pl.coderslab.futures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FuturesServiceImpl implements FuturesService{

    @Autowired
    FuturesRepository futuresRepository;


    @Override
    public void save(Future future) {
        futuresRepository.save(future);
    }

    @Override
    public void update(Future future) {
        futuresRepository.save(future);
    }

    @Override
    public void delete(Future future) {
        futuresRepository.delete(future);
    }

    @Override
    public Future find(Long id) {
        return futuresRepository.getOne(id);
    }

    @Override
    public List<Future> findAll() {
        return futuresRepository.findAll();
    }
}
