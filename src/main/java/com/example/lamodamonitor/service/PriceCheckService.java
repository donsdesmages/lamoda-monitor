package com.example.lamodamonitor.service;

import com.example.lamodamonitor.model.MonitorResponseDto;

public interface PriceCheckService {

    boolean checkPrice(MonitorResponseDto responseDto);
}
