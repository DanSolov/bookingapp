package com.github.DanSolov.bookingapp.repository;

import com.github.DanSolov.bookingapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Добавить методы для получения бронирований по пользователю или услуге
    List<Booking> findByUserId(Long userId);
    List<Booking> findByProductId(Long productId);
}
