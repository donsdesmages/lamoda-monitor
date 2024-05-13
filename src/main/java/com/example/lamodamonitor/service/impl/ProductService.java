package com.example.lamodamonitor.service.impl;

import com.example.lamodamonitor.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    void createProduct(String sku, Integer price);
    List<ProductEntity> getProduct();
}
