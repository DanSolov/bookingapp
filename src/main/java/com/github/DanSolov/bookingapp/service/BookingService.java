package com.github.DanSolov.bookingapp.service;

import com.github.DanSolov.bookingapp.model.Booking;
import com.github.DanSolov.bookingapp.model.Product;
import com.github.DanSolov.bookingapp.model.User;
import com.github.DanSolov.bookingapp.repository.BookingRepository;
import com.github.DanSolov.bookingapp.repository.ProductRepository;
import com.github.DanSolov.bookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
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

    // Получение услуги по id
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Получение пользователя по id
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
