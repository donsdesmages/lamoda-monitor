package com.example.lamodamonitor.client;

import com.example.lamodamonitor.model.MonitorResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "monitorClient", url = "${monitor.base-url}")
public interface MonitorClient {

    @GetMapping
    MonitorResponseDto getProductBySku(@RequestParam String sku);
}
