package pl.coderslab.account;

import java.util.List;

public interface AccountService {

    public void save (Account account);
    public void update (Account account);
    public void delete (Account account);
    public Account find (Long id);
    public List<Account> findAll();
}
