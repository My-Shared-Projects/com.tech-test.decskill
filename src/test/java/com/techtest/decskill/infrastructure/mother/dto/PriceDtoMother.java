package com.techtest.decskill.infrastructure.mother.dto;

import com.techtest.decskill.domain.mother.PriceMother;
import com.techtest.decskill.infrastructure.rest.dto.PriceDto;

public class PriceDtoMother {
    public static PriceDto getRandom() {
        return PriceDto.fromAggregate(PriceMother.getRandom());
    }
}
