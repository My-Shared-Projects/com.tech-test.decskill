package com.techtest.decskill.infrastructure.persistence.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long> {
}
