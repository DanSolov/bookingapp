package com.github.DanSolov.bookingapp.controller;

import com.github.DanSolov.bookingapp.model.Provider;
import com.github.DanSolov.bookingapp.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-providers")
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // Создание нового поставщика услуг
    @PostMapping
    public Provider createServiceProvider(@RequestBody Provider provider) {
        return providerService.createProvider(provider);
    }

    // Получение поставщика по имени
    @GetMapping("/name/{name}")
    public Provider getServiceProviderByName(@PathVariable String name) {
        return providerService.getProviderByName(name);
    }

    // Получение поставщика по id
    @GetMapping("/{id}")
    public Provider getServiceProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }
}
