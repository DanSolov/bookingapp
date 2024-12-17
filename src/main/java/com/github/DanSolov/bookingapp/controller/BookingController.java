package com.github.DanSolov.bookingapp.controller;

import com.github.DanSolov.bookingapp.model.Booking;
import com.github.DanSolov.bookingapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Booking createBooking(@RequestBody Booking booking) {
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
