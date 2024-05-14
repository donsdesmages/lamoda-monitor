package com.example.lamodamonitor.model;

public record MonitorResponseDto(
        //спросить у Вовы, не уверен что правильно
        String brand
) {
    public record Title(
            String brandName
    ) {

    }

}
