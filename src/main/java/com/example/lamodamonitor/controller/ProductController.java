package com.example.lamodamonitor.controller;

import com.example.lamodamonitor.entity.ProductEntity;
import com.example.lamodamonitor.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam String sku, @RequestParam Integer price) {
        productService.createProduct(sku, price);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getProduct() {
        return productService.getProduct();
    }
}
