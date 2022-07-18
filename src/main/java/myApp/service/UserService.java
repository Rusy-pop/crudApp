package myApp.service;

import myApp.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User readUserById(long userId);

    List<User> readAllUsers();

    void updateUser(User user);

    void deleteUserById(long id);
}
