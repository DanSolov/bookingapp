package com.github.DanSolov.bookingapp.repository;

import com.github.DanSolov.bookingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Если нужно добавить кастомные запросы, можно их здесь определить
    User findByEmail(String email);
}
