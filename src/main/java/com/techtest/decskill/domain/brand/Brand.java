package com.techtest.decskill.domain.brand;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Brand {
    private Long id;
    private String name;
    private boolean isActive;
}