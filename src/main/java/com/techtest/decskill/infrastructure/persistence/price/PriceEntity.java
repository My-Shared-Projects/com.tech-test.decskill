package com.techtest.decskill.infrastructure.persistence.price;

import com.techtest.decskill.domain.price.Price;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntity;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "price")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public static Price toAggregate(PriceEntity priceEntity) {
        return Price.builder()
                .priceList(priceEntity.getPriceList())
                .brand(BrandEntity.toAggregate(priceEntity.getBrand()))
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .product(ProductEntity.toAggregate(priceEntity.getProduct()))
                .priority(priceEntity.getPriority())
                .price(priceEntity.getPrice())
                .curr(priceEntity.getCurr())
                .build();
    }
}