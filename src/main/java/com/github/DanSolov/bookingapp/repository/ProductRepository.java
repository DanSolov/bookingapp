package com.github.DanSolov.bookingapp.repository;

import com.github.DanSolov.bookingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Можно добавить кастомные запросы, например, по названию услуги
    Product findByName(String name);
}
