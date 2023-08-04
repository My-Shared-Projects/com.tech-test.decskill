package com.techtest.decskill.infrastructure.persistence.brand;

import com.techtest.decskill.domain.mother.PrimitiveMother;

public class BrandEntityMother {
    public static BrandEntity getRandom() {
        return BrandEntity.builder()
                .id(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .name(PrimitiveMother.getRandomString())
                .isActive(PrimitiveMother.getRandomBoolean())
                .build();
    }
    public static BrandEntity getRandomFromId(long brandId) {
        return BrandEntity.builder()
                .id(brandId)
                .name(PrimitiveMother.getRandomString())
                .isActive(PrimitiveMother.getRandomBoolean())
                .build();
    }
}
