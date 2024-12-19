package com.github.DanSolov.bookingapp.controller;

import com.github.DanSolov.bookingapp.model.Booking;
import com.github.DanSolov.bookingapp.model.Product;
import com.github.DanSolov.bookingapp.model.Provider;
import com.github.DanSolov.bookingapp.model.User;
import com.github.DanSolov.bookingapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Создание нового бронирования
    @PostMapping
    public Booking createBooking(@RequestBody Map<String, Object> request) {
        // Получение полей из JSON
        Long userId = Long.parseLong(request.get("userId").toString());
        Long productId = Long.parseLong(request.get("productId").toString());
        String status = request.get("status").toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(request.get("startTime").toString(), formatter);

        // Загрузка пользователя по ID
        User user = bookingService.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("User with ID " + userId + " not found");
        }

        // Загрузка услуги по ID
        Product product = bookingService.findProductById(productId);
        if (product == null) {
            throw new RuntimeException("Product with ID " + productId + " not found");
        }

        // Создание нового бронирования
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setProduct(product);
        booking.setStatus(status);
        booking.setStartTime(startTime);

        return bookingService.createBooking(booking);
    }

    // Получение всех бронирований для пользователя
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    // Получение всех бронирований для услуги
    @GetMapping("/service/{serviceId}")
    public List<Booking> getBookingsByServiceId(@PathVariable Long serviceId) {
        return bookingService.getBookingsByServiceId(serviceId);
    }
}
