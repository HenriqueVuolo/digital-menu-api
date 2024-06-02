package com.vuolo.digitalmenu.use_cases.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class ValidateTokenUseCase {
  @Value("${api.security.token.secret}")
  private String secret;

  public DecodedJWT execute(String token) {
    token = token.replace("Bearer ", "");

    Algorithm algorithm = Algorithm.HMAC256(secret);

    try {
      return JWT.require(algorithm)
          .build()
          .verify(token);
    } catch (JWTVerificationException e) {
      return null;
    }
  }
}
