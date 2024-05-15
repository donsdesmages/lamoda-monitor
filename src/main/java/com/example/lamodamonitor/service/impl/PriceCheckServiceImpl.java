package com.example.lamodamonitor.service.impl;

import com.example.lamodamonitor.model.MonitorResponseDto;
import com.example.lamodamonitor.repository.ProductRepository;
import com.example.lamodamonitor.service.MonitorService;
import com.example.lamodamonitor.service.PriceCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
@RequiredArgsConstructor
public class PriceCheckServiceImpl implements PriceCheckService {
    private ProductRepository repository;

    private Map<String, Long> dataResponse;

    private MonitorService monitorService;

    @Override
    public Boolean checkPrice(String sku, Long price) {
        MonitorResponseDto responseDto = monitorService.monitorService(sku);

        if (dataResponse.isEmpty() & dataResponse.get(sku) == null) {
            dataResponse.put(responseDto.sku(), responseDto.price());
        }

        if (dataResponse.get(sku) > responseDto.price()) {
            Long productSku = repository.findPriceBySku(sku);
            if (productSku > responseDto.price()) {
                return true;
            }
            else {
                dataResponse.put(responseDto.sku(), responseDto.price());
            }
        }
        return false;
    }
}
