package myApp.Service;

import myApp.Model.User;
import myApp.Repo.UserRepo;
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
    public void create(User user) {
        userRepo.save(user);
    }

    @Override
    public User read(long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public List<User> readAll() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        userRepo.save(updateUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userRepo.deleteById(id);
    }
}
