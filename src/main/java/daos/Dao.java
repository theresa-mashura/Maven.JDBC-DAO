package daos;

import models.User;

import java.util.Set;

public interface Dao {

    User findById(int id);
    Set<User> findAllUsers();
    Integer createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);

}
