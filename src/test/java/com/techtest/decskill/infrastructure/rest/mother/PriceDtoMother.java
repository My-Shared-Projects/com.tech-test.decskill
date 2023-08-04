package com.techtest.decskill.infrastructure.rest.mother;

import com.techtest.decskill.domain.mother.PriceMother;
import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.infrastructure.rest.dto.PriceDto;

import java.time.LocalDateTime;

public class PriceDtoMother {
    public static PriceDto getRandom() {
        return getRandom(PrimitiveMother.getRandomLocalDateTime());
    }
    public static PriceDto getRandom(LocalDateTime date) {
        return PriceDto.fromAggregate(PriceMother.getRandom(date));
    }
}
