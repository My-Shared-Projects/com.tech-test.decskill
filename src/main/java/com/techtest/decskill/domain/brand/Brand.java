package com.techtest.decskill.domain.brand;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Brand {
    private Long id;
    private String name;
    private boolean isActive;
}