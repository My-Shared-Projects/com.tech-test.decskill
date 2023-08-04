package com.techtest.decskill.infrastructure.persistence.product;

import com.techtest.decskill.domain.mother.PrimitiveMother;

public class ProductEntityMother {
    public static ProductEntity getRandom() {
        return ProductEntity.builder()
                .id(PrimitiveMother.getRandomLong(0, PrimitiveMother.DEFAULT_LONG_LIMIT))
                .name(PrimitiveMother.getRandomString())
                .description(PrimitiveMother.getRandomString())
                .barcode(String.valueOf(PrimitiveMother.getRandomLong(0, 999999999999L)))
                .isActive(PrimitiveMother.getRandomBoolean())
                .build();
    }

    public static ProductEntity getRandomFromId(long productId) {
        ProductEntity product = getRandom();
        product.setId(productId);
        return product;
    }
}
