package com.techtest.decskill.infrastructure.persistence.price;

import com.techtest.decskill.domain.price.Price;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntity;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity(name = "price")
@Builder
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

    public static PriceEntity fromAggregate(Price price) {
        return PriceEntity.builder()
                .priceList(price.getPriceList())
                .brand(BrandEntity.fromAggregate(price.getBrand()))
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .product(ProductEntity.fromAggregate(price.getProduct()))
                .priority(price.getPriority())
                .price(price.getPrice())
                .curr(price.getCurr())
                .build();
    }
}