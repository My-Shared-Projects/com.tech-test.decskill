package com.techtest.decskill.infrastructure.persistence.price;

import com.techtest.decskill.domain.price.Price;
import com.techtest.decskill.domain.price.PriceNotFoundException;
import com.techtest.decskill.domain.price.PriceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final JpaPriceRepository priceRepository;
    @Override
    public Price findOne(Long brandId, Long productId, LocalDateTime date) throws PriceNotFoundException {
        try {
            PriceEntity foundEntity = this.priceRepository.findOneByBrandIdAndProductIdAndDate(brandId, productId, date);
            return PriceEntity.toAggregate(foundEntity);
        } catch (EntityNotFoundException exception) {
            throw new PriceNotFoundException("Entity not found");
        }
    }
}
