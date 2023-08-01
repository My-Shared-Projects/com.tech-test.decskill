package com.techtest.decskill.infrastructure.persistence.brand;

import com.techtest.decskill.domain.brand.Brand;
import jakarta.persistence.*;
import lombok.Builder;

@Entity(name = "brand")
@Builder
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isActive;

    public static BrandEntity fromAggregate(Brand brand) {
        return BrandEntity.builder()
                .id(brand.getId())
                .name(brand.getName())
                .isActive(brand.isActive())
                .build();
    }
}