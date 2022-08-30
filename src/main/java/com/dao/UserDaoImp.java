package com.dao;

import com.model.User;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUserList() {
        return entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User showUser(Long id) {
        TypedQuery<User> query =
                entityManager.createQuery("Select u from User u where u.id = :id", User.class)
                        .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = showUser(userId);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User current = showUser(id);
        current.setFirstName(user.getFirstName());
        current.setLastName(user.getLastName());
        current.setAge(user.getAge());
        current.setEmail(user.getEmail());
    }
}
