package com.example.lamodamonitor.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "monitorClient", url = "${monitor.base-url}")
public interface MonitorClient {

    @GetMapping
    MonitorStateResponse getProductBySku(@RequestParam String sku);
}
