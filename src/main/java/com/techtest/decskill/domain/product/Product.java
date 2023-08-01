package com.techtest.decskill.domain.product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private String barcode;
    private boolean isActive;
}