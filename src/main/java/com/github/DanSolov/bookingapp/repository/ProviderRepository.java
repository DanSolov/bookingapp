package com.github.DanSolov.bookingapp.repository;

import com.github.DanSolov.bookingapp.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    // Можно добавить кастомные запросы, например, по имени
    Provider findByName(String name);
}
