package com.techtest.decskill.infrastructure.rest.dto;

import com.techtest.decskill.domain.price.Price;
import lombok.Builder;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
public class PriceDto {
    private Long priceList;
    private Long productId;
    private Long brandId;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static PriceDto fromAggregate(Price price) {
        return PriceDto.builder()
                .priceList(price.getPriceList())
                .brandId(price.getBrand().getId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .productId(price.getProduct().getId())
                .price(price.getPrice())
                .build();
    }
}
