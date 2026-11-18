package com.example.stationerystore.service;

import com.example.stationerystore.model.User;
import com.example.stationerystore.model.UserRole;
import java.util.List;

public interface UserService {

    void addUser(User user);

    User findUserById(Long id);

    List<User> findAllUsers();

    void deleteUser(Long id);

    void updateUser(User user);

    List<User> findUsersByRole(UserRole role);

    User findUserByUsername(String username);
}