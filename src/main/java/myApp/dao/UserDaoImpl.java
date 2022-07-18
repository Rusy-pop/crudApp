package myApp.dao;

import myApp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public User findUserById(long userId) {
        Query query = em.createQuery("select u from User u where u.id = :userId", User.class);
        query.setParameter("userId", userId);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> findAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void updateUser(User updateUser) {
        em.merge(updateUser);
    }

    @Override
    public void deleteUser(long id) {
        System.out.println(id);
        em.createQuery("delete from User u where u.id = :id").setParameter("id", id).executeUpdate();
    }
}
