package com.github.DanSolov.bookingapp.service;

import com.github.DanSolov.bookingapp.model.Product;
import com.github.DanSolov.bookingapp.model.Provider;
import com.github.DanSolov.bookingapp.repository.ProductRepository;
import com.github.DanSolov.bookingapp.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProviderRepository providerRepository) {
        this.productRepository = productRepository;
        this.providerRepository = providerRepository;
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
    public Provider findProviderById(Long id) {
        return providerRepository.findById(id).orElse(null);
    }
}
