package com.vuolo.digitalmenu.exceptions;

public class IncorrectCredentialsException extends RuntimeException {

  public IncorrectCredentialsException() {
    super("E-mail ou senha incorretos");
  }
}
