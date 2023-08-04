package com.techtest.decskill.application.price;

import com.techtest.decskill.domain.mother.PriceMother;
import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.domain.price.Price;
import com.techtest.decskill.domain.price.PriceNotFoundException;
import com.techtest.decskill.domain.price.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceFinderServiceIntegrationTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceFinderService priceFinderService;

    @Test
    void findOne_returnsPrice_whenPriceExists() throws PriceNotFoundException {
        long brandId = PrimitiveMother.getRandomLong();
        long productId = PrimitiveMother.getRandomLong();
        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();

        Price expectedPrice = PriceMother.getRandom(brandId, productId, date);

        when(priceRepository.findOne(brandId, productId, date)).thenReturn(expectedPrice);

        Price foundPrice = priceFinderService.findOne(brandId, productId, date);

        assertEquals(expectedPrice, foundPrice);
    }

    @Test
    void findOne_throwsException_whenPriceNotFound() throws PriceNotFoundException {
        long brandId = PrimitiveMother.getRandomLong();
        long productId = PrimitiveMother.getRandomLong();
        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();

        when(priceRepository.findOne(brandId, productId, date)).thenThrow(new PriceNotFoundException("Price exception"));

        assertThrows(PriceNotFoundException.class, () -> priceFinderService.findOne(brandId, productId, date));
    }
}
