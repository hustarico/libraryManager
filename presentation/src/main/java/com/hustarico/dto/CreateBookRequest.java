package com.hustarico.dto;

public record CreateBookRequest(
        String title,
        String author,
        int yearOfPublication
) {
}
