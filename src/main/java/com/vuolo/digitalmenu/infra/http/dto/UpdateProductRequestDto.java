package com.vuolo.digitalmenu.infra.http.dto;

public record UpdateProductRequestDto(String name, String image, Double price, String description) {
}
