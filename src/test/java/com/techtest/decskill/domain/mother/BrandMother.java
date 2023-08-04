package com.techtest.decskill.domain.mother;

import com.techtest.decskill.domain.brand.Brand;

public class BrandMother {
    public static Brand getRandom() {
        return Brand.builder()
                .id(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .name(PrimitiveMother.getRandomString())
                .isActive(PrimitiveMother.getRandomBoolean())
                .build();
    }

    public static Brand getRandomFromId(long brandId) {
        Brand brand = getRandom();
        brand.setId(brandId);
        return brand;
    }
}
