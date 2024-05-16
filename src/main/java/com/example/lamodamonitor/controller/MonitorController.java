package com.example.lamodamonitor.controller;

import com.example.lamodamonitor.model.MonitorResponseDto;
import com.example.lamodamonitor.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
@RequiredArgsConstructor
public class MonitorController {

    private final MonitorService monitorService;

    @GetMapping
    public MonitorResponseDto getProductBySku(String sku) {
        return monitorService.getProductBySku(sku);
    }
}
