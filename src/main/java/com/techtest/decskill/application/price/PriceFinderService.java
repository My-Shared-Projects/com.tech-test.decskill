package com.techtest.decskill.application.price;

import com.techtest.decskill.domain.price.Price;
import com.techtest.decskill.domain.price.PriceNotFoundException;
import com.techtest.decskill.domain.price.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceFinderService {

    private final PriceRepository priceRepository;

    public Price findOne(Long brandId, Long productId, LocalDateTime date) throws PriceNotFoundException {
        return this.priceRepository.findOne(brandId, productId, date);
    }
}
