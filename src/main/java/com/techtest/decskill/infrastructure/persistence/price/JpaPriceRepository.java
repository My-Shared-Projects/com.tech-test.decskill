package com.techtest.decskill.infrastructure.persistence.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query("SELECT p FROM price p WHERE :date BETWEEN p.startDate AND p.endDate AND p.brand.id = :brandId AND p.product.id = :productId")
    PriceEntity findOneByBrandIdAndProductIdAndDate(Long brandId, Long productId, LocalDateTime date);
}
