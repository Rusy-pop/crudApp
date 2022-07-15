package myApp.dao;

import myApp.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User findUserById(long userId);

    List<User> findAllUsers();

    void updateUser(User user);

    void deleteUser(User user);
}
