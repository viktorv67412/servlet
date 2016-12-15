package com.dao;

import com.model.User;

import java.util.List;

/**
 * Created by viktor on 12/14/16.
 */
public interface UserDao {

    List<User> getAllUsers();

    List<User> addUser(User newUser);
}
