package com.indah.freshGoodiesBackend.products.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Product {
    private long id;

    @NotNull
    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Category is required")
    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Image URL is required")
    @NotBlank(message = "Image URL is required")
    private String imageUrl;

    @NotNull(message = "Price is required")
    private Double price;

    @NotNull(message = "Weight URL is required")
    @NotBlank(message = "Weight URL is required")
    private int weight;
    private Metadata metadata;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    public static class Metadata {
        @NotNull(message = "Unit is required")
        @NotBlank(message = "Unit is required")
        private String unit;

        @NotNull(message = "Weight is required")
        private Integer weight;

        @NotNull(message = "Calorie is required")
        private Integer calorie;

        @NotNull(message = "Proteins are required")
        private Double proteins;

        @NotNull(message = "Fats are required")
        private Double fats;

        @NotNull(message = "Increment is required")
        private Integer increment;

        @NotNull(message = "Carbs are required")
        private Integer carbs;
    }

}
