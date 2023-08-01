package com.techtest.decskill.infrastructure.persistence.brand;

import jakarta.persistence.*;

@Entity(name = "brand")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isActive;
}