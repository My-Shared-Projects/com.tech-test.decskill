package com.techtest.decskill.infrastructure.persistence.price;

import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntityMother;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntityMother;

import java.time.LocalDateTime;

public class PriceEntityMother {
    public static PriceEntity getRandom() {
        LocalDateTime startDate = PrimitiveMother.getRandomLocalDateTime();
        return PriceEntity.builder()
                .priceList(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .brand(BrandEntityMother.getRandom())
                .startDate(startDate)
                .endDate(PrimitiveMother.getRandomLocalDateTime(startDate, PrimitiveMother.DEFAULT_UPPER_DATE))
                .product(ProductEntityMother.getRandom())
                .priority(PrimitiveMother.getRandomInt(0, PrimitiveMother.DEFAULT_INT_LIMIT))
                .price(PrimitiveMother.getRandomDouble(0, PrimitiveMother.DEFAULT_DOUBLE_LIMIT))
                .curr(PrimitiveMother.getRandomString())
                .build();
    }

    public static PriceEntity getRandom(long brandId, long productId, LocalDateTime date) {
        LocalDateTime startDate = PrimitiveMother.getRandomLocalDateTime(PrimitiveMother.DEFAULT_LOWER_DATE, date);
        LocalDateTime endDate = PrimitiveMother.getRandomLocalDateTime(date, PrimitiveMother.DEFAULT_UPPER_DATE);
        return PriceEntity.builder()
                .priceList(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .brand(BrandEntityMother.getRandomFromId(brandId))
                .startDate(startDate)
                .endDate(endDate)
                .product(ProductEntityMother.getRandomFromId(productId))
                .priority(PrimitiveMother.getRandomInt(0, PrimitiveMother.DEFAULT_INT_LIMIT))
                .price(PrimitiveMother.getRandomDouble(0, PrimitiveMother.DEFAULT_DOUBLE_LIMIT))
                .curr(PrimitiveMother.getRandomString())
                .build();
    }
}
