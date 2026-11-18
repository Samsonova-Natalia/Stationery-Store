\# Stationery Store - Сервис для магазина канцелярских товаров



\## Описание

Клиент-серверное приложение для управления магазином канцелярских товаров с разграничением ролей пользователей (ADMIN, MANAGER, CUSTOMER).



\## Структура проекта

\- `model/` — классы сущностей (User, AdminUser, ManagerUser, CustomerUser) и enum UserRole

\- `service/` — бизнес-логика (интерфейс UserService и его реализация UserServiceImpl)

\- `collection/` — работа со структурами данных

\- `thread/` — многопоточная обработка данных



\## Технологии

\- Java 17

\- Spring Boot

\- Maven

\- JUnit 5

\- GitHub Actions (CI/CD)



\## Запуск тестов

```bash

mvn test

