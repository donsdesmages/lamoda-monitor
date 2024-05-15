package com.example.lamodamonitor.service.impl;

import com.example.lamodamonitor.entity.ProductEntity;
import com.example.lamodamonitor.model.MonitorResponseDto;
import com.example.lamodamonitor.repository.ProductRepository;
import com.example.lamodamonitor.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    private final MonitorServiceImpl service;

    @Override
    public MonitorResponseDto createProduct(String sku, Long price) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setPrice(price);
        productEntity.setSku(sku);

        repository.save(productEntity);

        return service.monitorService(sku);
    }

    @Override
    public List<ProductEntity> getProduct() {
        return repository.findAll();
    }
}
