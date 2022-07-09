package myApp.Service;

import myApp.Model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    User read(long userId);

    List<User> readAll();

    void update(User user);

    void delete(long id);
}
