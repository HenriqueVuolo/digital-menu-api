package com.vuolo.digitalmenu.use_cases.auth;

import com.vuolo.digitalmenu.domain.entities.Restaurant;
import com.vuolo.digitalmenu.domain.repositories.RestaurantRepository;
import com.vuolo.digitalmenu.exceptions.IncorrectCredentialsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {
  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private GenerateTokenUseCase generateToken;

  public String execute(Restaurant data) {
    Restaurant restaurant = this.restaurantRepository.findByEmail(data.getEmail())
        .orElseThrow(() -> new IncorrectCredentialsException());
    if (this.passwordEncoder.matches(data.getPassword(), restaurant.getPassword())) {
      return this.generateToken.execute(restaurant);
    }
    throw new IncorrectCredentialsException();
  }
}
