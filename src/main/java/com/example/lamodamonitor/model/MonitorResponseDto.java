package com.example.lamodamonitor.model;

import java.util.List;

public record MonitorResponseDto(

        String sku,

        String title,

        Long price,

        String seo_title,

        BestCategory best_category,

        List<Sizes> sizes,

        List<Attributes> attributes


) {

    public record BestCategory(
            String gender_segment,

            String image_url,

            String title

    ) {

    }

    public record Sizes(
            String primary_description,

            String secondary_description
    ) {

    }

    public record Attributes(
            String title,
            String value

    ) {

    }

}
