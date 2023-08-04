package com.techtest.decskill.infrastructure.rest.controller;

import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntity;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntityMother;
import com.techtest.decskill.infrastructure.persistence.brand.JpaBrandRepository;
import com.techtest.decskill.infrastructure.persistence.price.JpaPriceRepository;
import com.techtest.decskill.infrastructure.persistence.price.PriceEntity;
import com.techtest.decskill.infrastructure.persistence.price.PriceEntityMother;
import com.techtest.decskill.infrastructure.persistence.product.JpaProductRepository;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntity;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntityMother;
import com.techtest.decskill.infrastructure.rest.dto.PriceDto;
import com.techtest.decskill.infrastructure.rest.mother.PriceDtoMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceFinderControllerE2eTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JpaBrandRepository jpaBrandRepository;
    @Autowired
    private JpaProductRepository jpaProductRepository;
    @Autowired
    private JpaPriceRepository jpaPriceRepository;

    @AfterEach
    public void cleanRepositories() {
        jpaPriceRepository.deleteAll();
        jpaProductRepository.deleteAll();
        jpaBrandRepository.deleteAll();
    }

    @Test
    public void getPrice_returnsOkStatusCode_whenPriceNotFound() {
        BrandEntity brand = jpaBrandRepository.saveAndFlush(BrandEntityMother.getRandom());

        ProductEntity product = jpaProductRepository.saveAndFlush(ProductEntityMother.getRandom());

        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();
        PriceEntity price = jpaPriceRepository.saveAndFlush(PriceEntityMother.getRandom(brand.getId(), product.getId(), date));

        PriceDto expectedPrice = PriceDto.fromAggregate(PriceEntity.toAggregate(price));

        String url = "/prices?date=" + date + "&brandId=" + expectedPrice.getBrandId() + "&productId=" + expectedPrice.getProductId();

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(url, PriceDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    public void getPrice_returnsNotFoundStatusCode_whenPriceNotFound() {
        String url = "/prices?date=" + PrimitiveMother.getRandomLocalDateTime() + "&brandId=" + PrimitiveMother.getRandomLong() + "&productId=" + PrimitiveMother.getRandomLong();

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(url, PriceDto.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
