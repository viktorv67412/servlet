package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    List<User> addUser(User newUser);
}
