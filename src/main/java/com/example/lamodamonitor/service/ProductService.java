package com.example.lamodamonitor.service;

import com.example.lamodamonitor.entity.ProductEntity;
import com.example.lamodamonitor.model.MonitorResponseDto;

import java.util.List;

public interface ProductService {
    MonitorResponseDto createProduct(String sku, Long price);
    List<ProductEntity> getProduct();


}
