package com.vuolo.digitalmenu.infra.http.controllers;

import com.vuolo.digitalmenu.domain.entities.Restaurant;
import com.vuolo.digitalmenu.infra.http.dto.LoginRequestDTO;
import com.vuolo.digitalmenu.infra.http.dto.RegisterRequestDTO;
import com.vuolo.digitalmenu.use_cases.auth.LoginUseCase;
import com.vuolo.digitalmenu.use_cases.auth.RegisterUseCase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  LoginUseCase login;

  @Autowired
  RegisterUseCase register;

  @PostMapping("/login")
  public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestDTO body) throws Exception {
    try {
      String token = this.login.execute(Restaurant.builder()
          .email(body.email())
          .password(body.password())
          .build());
      return ResponseEntity.ok().body(token);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/register")
  public ResponseEntity<Object> register(@Valid @RequestBody RegisterRequestDTO body) throws Exception {
    try {
      String token = register.execute(Restaurant.builder()
          .name(body.name())
          .email(body.email())
          .password(body.password())
          .build());
      return ResponseEntity.ok().body(token);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }
}
