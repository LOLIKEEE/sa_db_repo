package sa.homework.jdbc.dao.interfaces;

import java.util.List;

public interface IDAO<T> {
    List<T> getAll();
    T getById(Integer id);
    boolean update(T object);
    boolean delete(T object);
    boolean create(T object);
    boolean exists(Integer id);
}
