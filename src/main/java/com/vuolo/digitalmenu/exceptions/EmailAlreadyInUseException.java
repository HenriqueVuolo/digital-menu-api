package com.vuolo.digitalmenu.exceptions;

public class EmailAlreadyInUseException extends RuntimeException {
  public EmailAlreadyInUseException() {
    super("Esse e-mail já está em uso");
  }
}
