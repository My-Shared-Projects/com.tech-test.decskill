package com.techtest.decskill.infrastructure.persistence.brand;

import com.techtest.decskill.domain.brand.Brand;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "brand")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isActive;

    public static Brand toAggregate(BrandEntity brandEntity) {
        return Brand.builder()
                .id(brandEntity.getId())
                .name(brandEntity.getName())
                .isActive(brandEntity.isActive())
                .build();
    }
}