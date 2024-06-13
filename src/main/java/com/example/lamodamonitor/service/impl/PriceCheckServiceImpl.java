package com.example.lamodamonitor.service.impl;

import com.example.lamodamonitor.model.MonitorResponseDto;
import com.example.lamodamonitor.repository.ProductRepository;
import com.example.lamodamonitor.service.PriceCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class PriceCheckServiceImpl implements PriceCheckService {
    private final ProductRepository repository;

    private final Map<String, Long> dataResponse = new HashMap<>();

    @Override
    public boolean checkPrice(MonitorResponseDto responseDto) {
        if (dataResponse.isEmpty() & dataResponse.get(responseDto.sku()) == null) {
            dataResponse.put(responseDto.sku(), responseDto.price());
        }

        List<Long> productSku = repository.findPriceBySku(responseDto.sku());
        if (responseDto.price() < productSku.getLast()) {
            return true;
        }
        else {
            dataResponse.put(responseDto.sku(), responseDto.price());
            return false;
        }

    }
}
