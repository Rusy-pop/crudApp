package myApp.service;

import myApp.dao.UserDao;
import myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User readUserById(long userId) {
        return userDao.findUserById(userId);
    }

    @Override
    @Transactional
    public List<User> readAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        userDao.updateUser(updateUser);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUser(id);
    }
}
