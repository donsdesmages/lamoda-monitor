package com.example.lamodamonitor.service;


import com.example.lamodamonitor.model.MonitorResponseDto;

public interface MonitorService {
    void monitor(String sku);

    MonitorResponseDto getProductBySku(String sku);
}
