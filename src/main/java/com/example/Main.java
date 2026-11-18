package com.example;

import com.example.stationerystore.model.AdminUser;
import com.example.stationerystore.model.CustomerUser;
import com.example.stationerystore.model.ManagerUser;
import com.example.stationerystore.model.User;
import com.example.stationerystore.model.UserRole;
import com.example.stationerystore.service.UserService;
import com.example.stationerystore.service.UserServiceImpl;
import com.example.stationerystore.thread.MultiThreadProcessor;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        AdminUser admin = new AdminUser(1L, "admin_ivan", "admin@shop.com", "IT Department");
        ManagerUser manager = new ManagerUser(2L, "manager_petr", "manager@shop.com", "Store #1");
        CustomerUser customer1 = new CustomerUser(3L, "customer_anna", "anna@mail.com", 100);
        CustomerUser customer2 = new CustomerUser(4L, "customer_boris", "boris@mail.com", 250);

        System.out.println("=== Добавление пользователей ===");
        userService.addUser(admin);
        userService.addUser(manager);
        userService.addUser(customer1);
        userService.addUser(customer2);

        System.out.println("\n=== Все пользователи ===");
        List<com.example.stationerystore.model.User> allUsers = userService.findAllUsers();
        for (com.example.stationerystore.model.User user : allUsers) {
            System.out.println(user);
        }

        System.out.println("\n=== Поиск по ID = 2 ===");
        com.example.stationerystore.model.User found = userService.findUserById(2L);
        System.out.println(found);

        System.out.println("\n=== Поиск пользователей с ролью CUSTOMER ===");
        List<com.example.stationerystore.model.User> customers = userService.findUsersByRole(UserRole.CUSTOMER);
        for (com.example.stationerystore.model.User user : customers) {
            System.out.println(user);
        }

        System.out.println("\n=== Удаление пользователя с ID = 1 ===");
        userService.deleteUser(1L);

        System.out.println("\n=== Все пользователи после удаления ===");
        allUsers = userService.findAllUsers();
        for (com.example.stationerystore.model.User user : allUsers) {
            System.out.println(user);
        }

        System.out.println("\n=================================");
        System.out.println("ТЕСТ МНОГОПОТОЧНОСТИ");
        System.out.println("=================================");

        List<com.example.stationerystore.model.User> usersForThreads = userService.findAllUsers();

        com.example.stationerystore.thread.MultiThreadProcessor processor = new com.example.stationerystore.thread.MultiThreadProcessor();
        processor.processUsers(usersForThreads);
    }
}