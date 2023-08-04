package com.techtest.decskill.domain.mother;

import com.techtest.decskill.domain.brand.Brand;

import java.time.LocalDateTime;

public class BrandMother {
    public static Brand getRandom() {
        LocalDateTime startDate = PrimitiveMother.getRandomLocalDateTime();
        return Brand.builder()
                .id(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .name(PrimitiveMother.getRandomString())
                .isActive(PrimitiveMother.getRandomBoolean())
                .build();
    }
}
