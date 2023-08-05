package com.techtest.decskill.infrastructure.rest.controller;

import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntity;
import com.techtest.decskill.infrastructure.persistence.brand.JpaBrandRepository;
import com.techtest.decskill.infrastructure.persistence.price.JpaPriceRepository;
import com.techtest.decskill.infrastructure.persistence.price.PriceEntity;
import com.techtest.decskill.infrastructure.persistence.product.JpaProductRepository;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntity;
import com.techtest.decskill.infrastructure.rest.dto.PriceDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceFinderControllerE2eCustomTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JpaBrandRepository jpaBrandRepository;
    @Autowired
    private JpaProductRepository jpaProductRepository;
    @Autowired
    private JpaPriceRepository jpaPriceRepository;

    @BeforeAll
    public void seedDatabase() {
        BrandEntity brand = this.seedBrands();
        ProductEntity product = this.seedProducts();
        this.seedPrices(brand, product);
    }

    @AfterAll
    public void cleanDatabase() {
        jpaPriceRepository.deleteAll();
        jpaProductRepository.deleteAll();
        jpaBrandRepository.deleteAll();
    }

    @Test
    public void getPrice_firstTest_returnsOkStatusCode_whenPriceIsFound() {
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0);
        PriceDto expectedPrice = PriceDto.builder()
                .priceList(1L)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .brandId(1L)
                .productId(35455L)
                .price(35.50)
                .build();

        String url = "/prices?date=" + date + "&brandId=" + expectedPrice.getBrandId() + "&productId=" + expectedPrice.getProductId();

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(url, PriceDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    public void getPrice_secondTest_returnsOkStatusCode_whenPriceIsFound() {
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 16, 0, 0);
        PriceDto expectedPrice = PriceDto.builder()
                .priceList(2L)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 14, 18, 30, 0))
                .brandId(1L)
                .productId(35455L)
                .price(25.45)
                .build();

        String url = "/prices?date=" + date + "&brandId=" + expectedPrice.getBrandId() + "&productId=" + expectedPrice.getProductId();

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(url, PriceDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    public void getPrice_thirdTest_returnsOkStatusCode_whenPriceIsFound() {
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 21, 0, 0);
        PriceDto expectedPrice = PriceDto.builder()
                .priceList(1L)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .brandId(1L)
                .productId(35455L)
                .price(35.50)
                .build();

        String url = "/prices?date=" + date + "&brandId=" + expectedPrice.getBrandId() + "&productId=" + expectedPrice.getProductId();

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(url, PriceDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    public void getPrice_fourthTest_returnsOkStatusCode_whenPriceIsFound() {
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 15, 10, 0, 0);
        PriceDto expectedPrice = PriceDto.builder()
                .priceList(3L)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 15, 11, 0, 0))
                .brandId(1L)
                .productId(35455L)
                .price(30.50)
                .build();

        String url = "/prices?date=" + date + "&brandId=" + expectedPrice.getBrandId() + "&productId=" + expectedPrice.getProductId();

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(url, PriceDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    public void getPrice_fifthTest_returnsOkStatusCode_whenPriceIsFound() {
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 16, 21, 0, 0);
        PriceDto expectedPrice = PriceDto.builder()
                .priceList(4L)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 16, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .brandId(1L)
                .productId(35455L)
                .price(38.95)
                .build();

        String url = "/prices?date=" + date + "&brandId=" + expectedPrice.getBrandId() + "&productId=" + expectedPrice.getProductId();

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(url, PriceDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    private BrandEntity seedBrands() {
        return jpaBrandRepository.saveAndFlush(BrandEntity.builder()
                .name("ZARA")
                .isActive(true)
                .build());
    }

    private ProductEntity seedProducts() {
        return jpaProductRepository.saveAndFlush(ProductEntity.builder()
                .id(35455L)
                .name(PrimitiveMother.getRandomString())
                .description(PrimitiveMother.getRandomString())
                .isActive(PrimitiveMother.getRandomBoolean())
                .build());
    }

    private void seedPrices(BrandEntity brand, ProductEntity product) {
        jpaPriceRepository.saveAndFlush(PriceEntity.builder()
                .brand(brand)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .product(product)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build());

        jpaPriceRepository.saveAndFlush(PriceEntity.builder()
                .brand(brand)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 14, 18, 30, 0))
                .product(product)
                .priority(1)
                .price(25.45)
                .curr("EUR")
                .build());

        jpaPriceRepository.saveAndFlush(PriceEntity.builder()
                .brand(brand)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 15, 11, 00, 0))
                .product(product)
                .priority(1)
                .price(30.50)
                .curr("EUR")
                .build());

        jpaPriceRepository.saveAndFlush(PriceEntity.builder()
                .brand(brand)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 16, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .product(product)
                .priority(1)
                .price(38.95)
                .curr("EUR")
                .build());
    }
}
