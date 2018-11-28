package pl.coderslab.operAcc;

import pl.coderslab.account.Account;

import java.util.List;

public interface OperAccService {
    public void save (OperAcc operAcc);
    public void update (OperAcc operAcc);
    public void deleteById (Long id);
    public OperAcc find (Long id);
    public List<OperAcc> findAll();
}
