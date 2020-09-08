package com.example.services;

import com.example.dao.UserDaoImpl;
import com.example.models.User;

public class UserService {

    private UserDaoImpl userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public User findUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    public String addUser(User user) {
        user.generateId(); //Fixme
        generatePassword(user); //Fixme
        userDao.save(user);
        User createUser = findUserByLogin(user.getLogin());
        return createUser != null ? createUser.getId() : null;
    }

    public User convertUser(User user) {
        generatePassword(user);
        return user;
    }

    private void generatePassword(User user) {
        //Todo complete generate hash of password
        user.setPassword(user.getPassword());
    }
}
