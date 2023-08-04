package com.techtest.decskill.domain.mother;

import com.techtest.decskill.domain.product.Product;

public class ProductMother {
    public static Product getRandom() {
        return Product.builder()
                .id(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .name(PrimitiveMother.getRandomString())
                .description(PrimitiveMother.getRandomString())
                .barcode(String.valueOf(PrimitiveMother.getRandomLong(0, 999999999999L)))
                .isActive(PrimitiveMother.getRandomBoolean())
                .build();
    }
}
