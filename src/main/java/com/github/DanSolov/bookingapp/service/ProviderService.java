package com.github.DanSolov.bookingapp.service;

import com.github.DanSolov.bookingapp.model.Provider;
import com.github.DanSolov.bookingapp.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    // Создание нового поставщика услуг
    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    // Получение поставщика по имени
    public Provider getProviderByName(String name) {
        return providerRepository.findByName(name);
    }

    // Получение поставщика по id
    public Provider getProviderById(Long id) {
        return providerRepository.findById(id).orElse(null);
    }
}
