
package com.task2.service;

import java.util.List;

import com.task2.model.User;

public interface UserService {

    public List<User> allUsers();

    public User getUserByEmail(String email);

    public User getUserById(Long userId);

    public void saveUser(User user);

    public void deleteUser(Long userId);

    public void updateUser(User user);

}
