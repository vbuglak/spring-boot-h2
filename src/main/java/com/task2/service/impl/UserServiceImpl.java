/**
 *
 */
package com.task2.service.impl;

import java.util.List;

import com.task2.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.task2.model.User;
import com.task2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> allUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User getUserById(Long userId) {
        User user = userRepository.findOne(userId);
        return user;
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }


}
