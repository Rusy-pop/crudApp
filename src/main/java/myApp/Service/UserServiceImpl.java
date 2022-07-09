package myApp.Service;

import myApp.DAO.UserDao;
import myApp.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public void create(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User read(long userId) {
        return userDao.findById(userId);
    }

    @Override
    @Transactional
    public List<User> readAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        userDao.update(updateUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.deleteById(id);
    }
}
