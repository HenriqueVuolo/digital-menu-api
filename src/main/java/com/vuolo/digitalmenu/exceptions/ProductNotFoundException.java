package com.vuolo.digitalmenu.exceptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException() {
    super("Produto não encontrado");
  }
}