package com.security.services;

import com.security.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("santosh", "Iphone5541@123", "santoshluitel19@outlook.com"));
        list.add(new User("rojina", "gmail123", "karkirojina84@gmail.com"));
        list.add(new User("aavash", "aavash123", "aavashbhujel18@gmail.com"));
    }

    //get all users
    public List<User> getAllUsers() {
        return this.list;
    }

    //get single user
    public User getUser(String username) {
        return this.list.stream()
                .filter(user -> user.getUserName().equals(username))
                .findFirst()
                .orElse(null);
    }

    //add new user
    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
