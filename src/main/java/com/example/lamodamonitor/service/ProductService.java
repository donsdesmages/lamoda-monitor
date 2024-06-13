package com.example.lamodamonitor.service;

import com.example.lamodamonitor.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    void createProduct(String sku, Long price, String mail);
    List<ProductEntity> getProduct();


}
