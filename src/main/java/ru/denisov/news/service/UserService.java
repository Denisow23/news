package ru.denisov.news.service;

import ru.denisov.news.domain.user.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUser(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);

}
