package com.github.DanSolov.bookingapp.service;

import com.github.DanSolov.bookingapp.model.User;
import com.github.DanSolov.bookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Создание нового пользователя
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Получение пользователя по email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Получение пользователя по id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
