package com.vuolo.digitalmenu.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
  public RestaurantNotFoundException() {
    super("Usuário não encontrado");
  }
}
