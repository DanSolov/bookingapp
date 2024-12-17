package com.github.DanSolov.bookingapp.service;

import com.github.DanSolov.bookingapp.model.Product;
import com.github.DanSolov.bookingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Создание новой услуги
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Получение услуги по названию
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    // Получение услуги по id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
