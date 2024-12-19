package com.github.DanSolov.bookingapp.controller;

import com.github.DanSolov.bookingapp.model.Product;
import com.github.DanSolov.bookingapp.model.Provider;
import com.github.DanSolov.bookingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/services")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Создание новой услуги
    @PostMapping
    public Product createProduct(@RequestBody Map<String, Object> request) {
        // Получение полей из JSON
        Long providerId = Long.parseLong(request.get("providerId").toString());
        String name = request.get("name").toString();
        String description = request.get("description").toString();
        Double price = Double.parseDouble(request.get("price").toString());

        // Загрузка провайдера по ID
        Provider provider = productService.findProviderById(providerId);
        if (provider == null) {
            throw new RuntimeException("Provider with ID " + providerId + " not found");
        }

        // Создание нового продукта
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setProvider(provider);

        // Сохранение продукта
        return productService.createProduct(product);
    }


    // Получение услуги по названию
    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    // Получение услуги по id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
