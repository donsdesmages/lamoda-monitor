package com.example.lamodamonitor.service;


import com.example.lamodamonitor.model.MonitorResponseDto;

public interface MonitorService {
    void monitor(String sku, String mail);

    MonitorResponseDto getProductBySku(String sku);
}
