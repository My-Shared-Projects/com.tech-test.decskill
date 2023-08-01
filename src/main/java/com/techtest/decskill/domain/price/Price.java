package com.techtest.decskill.domain.price;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Price {
    private Long priceList;
    private Long brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long product;
    private Integer priority;
    private Double price;
    private String curr;

}