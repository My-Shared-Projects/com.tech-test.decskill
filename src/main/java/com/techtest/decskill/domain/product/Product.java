package com.techtest.decskill.domain.product;

import lombok.Getter;

@Getter
public class Product {
    private Long id;
    private String name;
    private String description;
    private String barcode;
    private boolean isActive;
}