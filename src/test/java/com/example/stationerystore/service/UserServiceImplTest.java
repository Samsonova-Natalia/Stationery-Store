package com.example.stationerystore.service;

import com.example.stationerystore.model.AdminUser;
import com.example.stationerystore.model.CustomerUser;
import com.example.stationerystore.model.ManagerUser;
import com.example.stationerystore.model.User;
import com.example.stationerystore.model.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class UserServiceImplTest {

    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void testAddUser() {
        User admin = new AdminUser(1L, "admin_ivan", "admin@shop.com", "IT");

        userService.addUser(admin);

        User found = userService.findUserById(1L);
        assertNotNull(found, "Пользователь должен быть найден");
        assertEquals("admin_ivan", found.getUsername(), "Имена должны совпадать");
        assertEquals(UserRole.ADMIN, found.getRole(), "Роль должна быть ADMIN");
    }

    @Test
    void testFindUsersByRole() {
        userService.addUser(new AdminUser(1L, "admin1", "a@shop.com", "IT"));
        userService.addUser(new CustomerUser(2L, "cust1", "c@shop.com", 100));
        userService.addUser(new CustomerUser(3L, "cust2", "c2@shop.com", 200));
        userService.addUser(new ManagerUser(4L, "mgr1", "m@shop.com", "Store1"));

        List<User> customers = userService.findUsersByRole(UserRole.CUSTOMER);

        assertEquals(2, customers.size(), "Должно быть найдено 2 покупателя");
        for (User user : customers) {
            assertEquals(UserRole.CUSTOMER, user.getRole());
        }
    }

    @Test
    void testDeleteUser() {
        userService.addUser(new AdminUser(1L, "admin1", "a@shop.com", "IT"));
        userService.deleteUser(1L);

        User found = userService.findUserById(1L);
        assertNull(found, "Пользователь должен быть удален (вернуть null)");

        List<User> allUsers = userService.findAllUsers();
        assertEquals(0, allUsers.size(), "Список пользователей должен быть пуст");
    }

    @Test
    void testUpdateUser() {
        User admin = new AdminUser(1L, "admin_old", "old@shop.com", "IT");
        userService.addUser(admin);

        User updatedAdmin = new AdminUser(1L, "admin_new", "new@shop.com", "HR");
        userService.updateUser(updatedAdmin);

        User found = userService.findUserById(1L);
        assertEquals("admin_new", found.getUsername(), "Имя должно обновиться");
        assertEquals("new@shop.com", found.getEmail(), "Почта должна обновиться");
    }
}