package com.techtest.decskill.infrastructure.rest.controller;

import java.time.LocalDateTime;

import com.techtest.decskill.application.price.PriceFinderService;
import com.techtest.decskill.domain.price.PriceNotFoundException;
import com.techtest.decskill.infrastructure.rest.dto.PriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceFinderController {

    private final PriceFinderService priceFinderService;

    @GetMapping
    public ResponseEntity<PriceDto> getPrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam Long brandId,
            @RequestParam Long productId
    ) {
        try {
            PriceDto response = PriceDto.fromAggregate(this.priceFinderService.findOne(brandId, productId, date));
            return ResponseEntity.ok(response);
        } catch (PriceNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}

