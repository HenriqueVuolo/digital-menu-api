package com.vuolo.digitalmenu.infra.http.dto;

public record CreateProductRequestDto(String name, String image, Double price, String description) {
}
