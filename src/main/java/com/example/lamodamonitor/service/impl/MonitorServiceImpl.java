package com.example.lamodamonitor.service.impl;

import com.example.lamodamonitor.client.MonitorClient;
import com.example.lamodamonitor.model.MonitorResponseDto;
import com.example.lamodamonitor.service.MonitorService;
import com.example.lamodamonitor.service.PriceCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {

    private final MonitorClient monitorClient;

    private PriceCheckService priceCheckService;

    @Override
    public MonitorResponseDto monitorService(String sku) {
        while (true) {
            return monitorClient.getProductBySku(sku);
        }
    }
}
