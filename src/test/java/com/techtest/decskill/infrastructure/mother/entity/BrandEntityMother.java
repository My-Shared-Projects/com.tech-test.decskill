package com.techtest.decskill.infrastructure.mother.entity;

import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntity;

public class BrandEntityMother {
    public static BrandEntity getRandom() {
        return BrandEntity.builder()
                .id(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .name(PrimitiveMother.getRandomString())
                .isActive(PrimitiveMother.getRandomBoolean())
                .build();
    }
}
