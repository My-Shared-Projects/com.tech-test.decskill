package com.techtest.decskill.infrastructure.persistence.price;

import com.techtest.decskill.infrastructure.persistence.brand.BrandEntity;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "price")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceList;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private Integer priority;
    private Double price;
    private String curr;

}