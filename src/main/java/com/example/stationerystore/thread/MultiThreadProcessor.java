package com.example.stationerystore.thread;

import com.example.stationerystore.model.User;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadProcessor {

    public void processUsers(List<User> users) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("--- Начало многопоточной обработки " + users.size() + " пользователей ---");

        for (User user : users) {
            executor.execute(() -> {
                Thread currentThread = Thread.currentThread();
                currentThread.setName("Worker-Thread-" + user.getId());

                System.out.println("Поток [" + currentThread.getName() + "] начал обработку: " + user.getUsername() + " (Роль: " + user.getRole() + ")");

                try {
                    Thread.sleep(500); // Поток "спит" полсекунды
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Поток был прерван: " + e.getMessage());
                }

                System.out.println("Поток [" + currentThread.getName() + "] завершил обработку: " + user.getUsername());
            });
        }

        executor.shutdown();
        System.out.println("--- Все задачи отправлены в пул. Ожидаем завершения... ---");
    }
}