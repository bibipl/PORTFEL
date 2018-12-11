package pl.coderslab.futures;


import java.util.List;

public interface FutureService {
    public void save (Future future);
    public void update (Future future);
    public void deleteById (Long id);
    public Future find (Long id);
    public List<Future> findAll();
    List<Future> findByIsin(String isin);
    List<Future> findByName(String name);
}
