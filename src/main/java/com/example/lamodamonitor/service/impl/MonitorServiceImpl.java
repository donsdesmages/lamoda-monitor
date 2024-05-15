package com.example.lamodamonitor.service.impl;

import com.example.lamodamonitor.client.MonitorClient;
import com.example.lamodamonitor.model.MonitorResponseDto;
import com.example.lamodamonitor.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {

    private final MonitorClient monitorClient;

    @Override
    public MonitorResponseDto monitorService(String sku) {
        return monitorClient.getProductBySku(sku);
    }
}
