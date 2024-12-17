package com.github.DanSolov.bookingapp.controller;

import com.github.DanSolov.bookingapp.model.User;
import com.github.DanSolov.bookingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Создание нового пользователя
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }



    // Получение пользователя по email
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Получение пользователя по id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
