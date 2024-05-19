package com.example.lamodamonitor.service.impl;

import com.example.lamodamonitor.client.MonitorClient;
import com.example.lamodamonitor.mail.DispatchService;
import com.example.lamodamonitor.model.MonitorResponseDto;
import com.example.lamodamonitor.service.MonitorService;
import com.example.lamodamonitor.service.PriceCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {

    private final MonitorClient monitorClient;

    private final PriceCheckService priceCheckService;

    private final DispatchService dispatchService;


    @Override
    public void monitor(String sku, String mail) {
        new Thread(() -> {
            while (true) {
                MonitorResponseDto response = monitorClient.getProductBySku(sku);

                boolean resultCheckPrice = priceCheckService.checkPrice(response);

                if (resultCheckPrice) {
                    dispatchService.sendMessage(mail, response);
                    break;
                }

                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    @Override
    public MonitorResponseDto getProductBySku(String sku) {
        return monitorClient.getProductBySku(sku);
    }
}
