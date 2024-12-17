package com.github.DanSolov.bookingapp.service;

import com.github.DanSolov.bookingapp.model.Booking;
import com.github.DanSolov.bookingapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Создание нового бронирования
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Получение всех бронирований для пользователя
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Получение всех бронирований для услуги
    public List<Booking> getBookingsByServiceId(Long productId) {
        return bookingRepository.findByProductId(productId);
    }
}
