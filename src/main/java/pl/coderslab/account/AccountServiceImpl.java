package pl.coderslab.account;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void save (Account account) {
        accountRepository.save(account);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);

    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);

    }

    @Override
    public Account find(Long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
