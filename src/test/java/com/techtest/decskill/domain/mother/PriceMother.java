package com.techtest.decskill.domain.mother;

import com.techtest.decskill.domain.price.Price;

import java.time.LocalDateTime;

public class PriceMother {
    public static Price getRandom() {
        LocalDateTime startDate = PrimitiveMother.getRandomLocalDateTime();
        return Price.builder()
                .priceList(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .brand(BrandMother.getRandom())
                .startDate(startDate)
                .endDate(PrimitiveMother.getRandomLocalDateTime(startDate, PrimitiveMother.DEFAULT_UPPER_DATE))
                .product(ProductMother.getRandom())
                .priority(PrimitiveMother.getRandomInt(0, PrimitiveMother.DEFAULT_INT_LIMIT))
                .price(PrimitiveMother.getRandomDouble(0, PrimitiveMother.DEFAULT_DOUBLE_LIMIT))
                .curr(PrimitiveMother.getRandomString())
                .build();
    }
}
