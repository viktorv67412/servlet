package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<User> addUser(User newUser) {
        return userDao.addUser(newUser);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
