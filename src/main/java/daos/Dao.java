package daos;

import models.User;

import java.util.Set;

public interface Dao<T> {

    User findById(int id);
    Set<T> findAll();
    Integer create(User user);
    boolean update(User user);
    boolean delete(int id);

}
