package com.furqan.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequestDto {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author name is required")
    private String author;

    @NotNull(message = "Price should not be null")
    private Double price;

    public @NotBlank(message = "Title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required") String title) {
        this.title = title;
    }

    public @NotBlank(message = "Author name is required") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotBlank(message = "Author name is required") String author) {
        this.author = author;
    }

    public @NotNull(message = "Price should not be null") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price should not be null") Double price) {
        this.price = price;
    }
}
