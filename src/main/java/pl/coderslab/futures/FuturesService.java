package pl.coderslab.futures;


import java.util.List;

public interface FuturesService  {
    public void save (Future future);
    public void update (Future future);
    public void delete (Future future);
    public Future find (Long id);
    public List<Future> findAll();
}
