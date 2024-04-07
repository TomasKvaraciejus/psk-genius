package persistence;

import java.util.List;

public interface IDAO<T> {
    T findById(long id);
    List<T> findAll();
    void save (T entity);
    T update (T entity);
    void delete(T entity);
}
