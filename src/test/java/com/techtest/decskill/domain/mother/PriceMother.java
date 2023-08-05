package com.techtest.decskill.domain.mother;

import com.techtest.decskill.domain.price.Price;

import java.time.LocalDateTime;

public class PriceMother {
    public static Price getRandom() {
        return getRandom(PrimitiveMother.getRandomLocalDateTime());
    }

    public static Price getRandom(LocalDateTime date) {
        return getRandom(PrimitiveMother.getRandomLong(), PrimitiveMother.getRandomLong(), date);
    }

    public static Price getRandom(long brandId, long productId, LocalDateTime date) {
        LocalDateTime startDate = PrimitiveMother.getRandomLocalDateTime(PrimitiveMother.DEFAULT_LOWER_DATE, date);
        LocalDateTime endDate = PrimitiveMother.getRandomLocalDateTime(date, PrimitiveMother.DEFAULT_UPPER_DATE);
        return Price.builder()
                .priceList(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .brand(BrandMother.getRandomFromId(brandId))
                .startDate(startDate)
                .endDate(endDate)
                .product(ProductMother.getRandomFromId(productId))
                .priority(PrimitiveMother.getRandomInt(0, PrimitiveMother.DEFAULT_INT_LIMIT))
                .price(PrimitiveMother.getRandomDouble(0, PrimitiveMother.DEFAULT_DOUBLE_LIMIT))
                .curr(PrimitiveMother.getRandomString())
                .build();
    }
}
