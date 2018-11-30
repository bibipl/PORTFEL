package pl.coderslab.futures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FutureServiceImpl implements FutureService {

    @Autowired
    FutureRepository futuresRepository;


    @Override
    public void save(Future future) {
        futuresRepository.save(future);
    }

    @Override
    public void update(Future future) {
        futuresRepository.save(future);
    }

    @Override
    public void deleteById(Long id) {
        futuresRepository.deleteById(id);
    }

    @Override
    public Future find(Long id) {
        return futuresRepository.findById(id).orElse(null);
    }

    @Override
    public List<Future> findAll() {
        return futuresRepository.findAll();
    }

    @Override
    public List<Future> findByIsin(String isin) {
        return futuresRepository.findByIsin(isin);
    }
}
