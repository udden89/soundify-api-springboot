package com.soundify.api.soundifyapi.service;


import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.repository.UserRepository;
import com.soundify.api.soundifyapi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String id) {
        return userRepository.findById(id);
    }


    public Optional<User> addUser(User user) {
        var id = userRepository.insert(user).get_id();
        return findUser(id);
    }

    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll() ;
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}
