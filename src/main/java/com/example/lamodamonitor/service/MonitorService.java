package com.example.lamodamonitor.service;

import com.example.lamodamonitor.client.MonitorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorClient monitorClient;
    public void monitorService(String sku) {
        while (true) {
            monitorClient.getProductBySku(sku);
        }
    }
}
