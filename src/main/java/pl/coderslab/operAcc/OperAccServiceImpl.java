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

    }

    @Override
    public void update(OperAcc operAcc) {

    }

    @Override
    public void delete(OperAcc operAcc) {

    }

    @Override
    public OperAcc find(Long id) {
        return operAccRepository.getOne(id);
    }

    @Override
    public List<OperAcc> findAll() {
        return operAccRepository.findAll();
    }
}
