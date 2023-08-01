package com.techtest.decskill.domain.price;

import com.techtest.decskill.domain.brand.Brand;
import com.techtest.decskill.domain.product.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Price {
    private Long priceList;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Product product;
    private Integer priority;
    private Double price;
    private String curr;

}