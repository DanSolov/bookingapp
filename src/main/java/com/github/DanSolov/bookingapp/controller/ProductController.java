package com.github.DanSolov.bookingapp.controller;

import com.github.DanSolov.bookingapp.model.Product;
import com.github.DanSolov.bookingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Product createService(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Получение услуги по названию
    @GetMapping("/name/{name}")
    public Product getServiceByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    // Получение услуги по id
    @GetMapping("/{id}")
    public Product getServiceById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
