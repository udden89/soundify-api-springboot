package com.soundify.api.soundifyapi.service;


import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }


    public Optional<User> addUser(User user) {
        System.out.println("inside add user ");
        var id = userRepository.insert(user).get_id();
        var newUser = findUser(id);
        return newUser;
    }

    public List<User> getAllUsers() {
        System.out.println("find all");
        List<User> list = userRepository.findAll() ;
        System.out.println(list);
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
