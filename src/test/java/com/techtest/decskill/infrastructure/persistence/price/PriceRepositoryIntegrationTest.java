package com.techtest.decskill.infrastructure.persistence.price;

import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.domain.price.Price;
import com.techtest.decskill.domain.price.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceRepositoryIntegrationTest {

    @Mock
    private JpaPriceRepository jpaPriceRepository;

    @InjectMocks
    private PriceRepositoryImpl priceRepositoryImpl;

    @Test
    void findOne_returnsPrice_whenEntityExists() throws PriceNotFoundException {
        long brandId = PrimitiveMother.getRandomLong();
        long productId = PrimitiveMother.getRandomLong();
        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();

        PriceEntity expectedEntity = PriceEntityMother.getRandom(brandId, productId, date);
        Price expectedPrice = PriceEntity.toAggregate(expectedEntity);

        when(jpaPriceRepository.findOneByBrandIdAndProductIdAndDate(brandId, productId, date)).thenReturn(expectedEntity);

        Price foundPrice = priceRepositoryImpl.findOne(brandId, productId, date);

        assertThat(foundPrice).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    void findOne_throwsException_whenEntityNotFound() {
        long brandId = PrimitiveMother.getRandomLong();
        long productId = PrimitiveMother.getRandomLong();
        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();

        when(jpaPriceRepository.findOneByBrandIdAndProductIdAndDate(brandId, productId, date)).thenReturn(null);

        assertThrows(PriceNotFoundException.class, () -> priceRepositoryImpl.findOne(brandId, productId, date));
    }
}
