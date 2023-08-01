package com.techtest.decskill.infrastructure.persistence.product;

import com.techtest.decskill.domain.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity(name = "product")
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String barcode;
    private boolean isActive;

    public static ProductEntity fromAggregate(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .barcode(product.getBarcode())
                .isActive(product.isActive())
                .build();
    }
}