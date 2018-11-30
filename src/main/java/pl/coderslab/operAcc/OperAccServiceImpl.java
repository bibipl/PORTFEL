package pl.coderslab.operAcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperAccServiceImpl implements OperAccService{

    @Autowired
    OperAccRepository operAccRepository;


    @Override
    public void save(OperAcc operAcc) {
        operAccRepository.save(operAcc);

    }

    @Override
    public void update(OperAcc operAcc) {
        operAccRepository.save(operAcc);
    }

    @Override
    public void deleteById(Long id) {
        operAccRepository.deleteById(id);
    }

    @Override
    public OperAcc find(Long id) {
        return operAccRepository.findById(id).orElse(null);
    }

    @Override
    public List<OperAcc> findAll() {
        return operAccRepository.findAll();
    }

    @Override
    public List<OperAcc> findAllByAccountId(Long id) {
        return operAccRepository.findAllByAccountId(id);
    }
}
