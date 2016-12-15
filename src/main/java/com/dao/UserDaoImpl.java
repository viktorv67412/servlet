package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private List<User> users = new ArrayList<User>(
            Arrays.asList(new User("name1", "password1", "age1", "phoneNumber1", "homeAddress1", "email1"),
                    new User("name2", "password2", "age2", "phoneNumber2", "homeAddress2", "email2")));

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> addUser(User newUser) {
        users.add(newUser);
        return users;
    }
}
