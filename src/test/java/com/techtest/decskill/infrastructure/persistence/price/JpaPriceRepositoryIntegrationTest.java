package com.techtest.decskill.infrastructure.persistence.price;

import com.techtest.decskill.domain.mother.PrimitiveMother;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntity;
import com.techtest.decskill.infrastructure.persistence.brand.JpaBrandRepository;
import com.techtest.decskill.infrastructure.persistence.brand.BrandEntityMother;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntityMother;
import com.techtest.decskill.infrastructure.persistence.product.JpaProductRepository;
import com.techtest.decskill.infrastructure.persistence.product.ProductEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaPriceRepositoryIntegrationTest {

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
    public void findOneByBrandIdAndProductIdAndDate_returnsEntity_whenEntityExists() {
        BrandEntity brand = jpaBrandRepository.saveAndFlush(BrandEntityMother.getRandom());

        ProductEntity product = jpaProductRepository.saveAndFlush(ProductEntityMother.getRandom());

        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();
        PriceEntity expectedPrice = jpaPriceRepository.saveAndFlush(PriceEntityMother.getRandom(brand.getId(), product.getId(), date));

        PriceEntity savedEntity = jpaPriceRepository.findOneByBrandIdAndProductIdAndDate(brand.getId(), product.getId(), date);

        assertThat(savedEntity).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    public void findOneByBrandIdAndProductIdAndDate_returnsEntityWithHighestPriority_whenEntityExists() {
        BrandEntity brand = jpaBrandRepository.saveAndFlush(BrandEntityMother.getRandom());

        ProductEntity product = jpaProductRepository.saveAndFlush(ProductEntityMother.getRandom());

        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();
        int limit = PrimitiveMother.getRandomInt(1, 20);
        IntStream.of(limit).forEach(i -> {
            jpaPriceRepository.saveAndFlush(PriceEntityMother.getRandom(brand.getId(), product.getId(), date));
        });
        PriceEntity expectedPrice = jpaPriceRepository.findAll().stream().sorted(Comparator.comparing(PriceEntity::getPriority)).toList().get(0);

        PriceEntity savedEntity = jpaPriceRepository.findOneByBrandIdAndProductIdAndDate(brand.getId(), product.getId(), date);

        assertThat(savedEntity).usingRecursiveComparison().isEqualTo(expectedPrice);
    }

    @Test
    public void findOneByBrandIdAndProductIdAndDate_returnsNull_whenEntityNotExists() {
        long brandId = PrimitiveMother.getRandomLong();
        long productId = PrimitiveMother.getRandomLong();
        LocalDateTime date = PrimitiveMother.getRandomLocalDateTime();
        assertNull(jpaPriceRepository.findOneByBrandIdAndProductIdAndDate(brandId, productId, date));
    }
}
