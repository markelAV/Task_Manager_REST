package com.example.dao;

import com.example.models.User;
import com.example.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class UserDaoImpl extends CRUDTaskManagerImpl<User> {
    public UserDaoImpl() {
        super(User.class);
    }

    public User getUserByLogin(String login) {
        List<User> users;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = session.createQuery("from User where login = :login"); //Todo change
        query.setParameter("login", login);
        users = query.getResultList(); //Todo getResultList change
        return users.size() > 0 ? users.get(0) : null; // todo check user and return null
    }
}
