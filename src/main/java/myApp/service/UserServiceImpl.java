package myApp.service;

import myApp.model.User;
import myApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    @Autowired
    UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User readUserById(long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public List<User> readAllUsers() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        userRepo.save(updateUser);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }
}
