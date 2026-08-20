package com.example.CRUD.domain.product;

import jakarta.validation.constraints.NotBlank;

public record RequestProduct(
        Integer id,

        @NotBlank
        String name,

        @NotBlank
        String technology,

        @NotBlank
        String category,

        String description) {
}

