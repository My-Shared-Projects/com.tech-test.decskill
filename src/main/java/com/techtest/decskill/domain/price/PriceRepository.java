package com.techtest.decskill.domain.price;

import java.time.LocalDateTime;

public interface PriceRepository {
    Price findOne(Long brandId, Long productId, LocalDateTime date) throws PriceNotFoundException;
}