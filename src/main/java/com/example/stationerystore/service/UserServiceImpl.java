package com.example.stationerystore.service;

import com.example.stationerystore.model.User;
import com.example.stationerystore.model.UserRole;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private final List<User> userList = new ArrayList<>();

    private final Map<Long, User> userMap = new HashMap<>();

    private Long nextId = 1L;

    @Override
    public void addUser(User user) {
        if (user.getId() == null) {
            user.setId(nextId);
            nextId++;
        }

        userList.add(user);
        userMap.put(user.getId(), user);

        System.out.println("Пользователь добавлен: " + user.getUsername());
    }

    @Override
    public User findUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(userList);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userMap.remove(id);
        if (user != null) {
            userList.remove(user);
            System.out.println("Пользователь удален: " + user.getUsername());
        } else {
            System.out.println("Пользователь с ID " + id + " не найден");
        }
    }

    @Override
    public void updateUser(User updatedUser) {
        if (updatedUser.getId() == null) {
            System.out.println("Ошибка: ID пользователя не может быть null");
            return;
        }

        User existingUser = userMap.get(updatedUser.getId());
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setRole(updatedUser.getRole());
            System.out.println("Пользователь обновлен: " + existingUser.getUsername());
        } else {
            System.out.println("Пользователь с ID " + updatedUser.getId() + " не найден");
        }
    }

    @Override
    public List<User> findUsersByRole(UserRole role) {
        List<User> result = new ArrayList<>();

        for (User user : userList) {
            if (user.getRole() == role) {
                result.add(user);
            }
        }

        return result;
    }

    @Override
    public User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername() != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}