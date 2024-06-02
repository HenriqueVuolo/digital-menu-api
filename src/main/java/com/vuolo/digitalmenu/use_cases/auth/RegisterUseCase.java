package com.vuolo.digitalmenu.use_cases.auth;

import com.vuolo.digitalmenu.domain.entities.Restaurant;
import com.vuolo.digitalmenu.domain.repositories.RestaurantRepository;
import com.vuolo.digitalmenu.exceptions.EmailAlreadyInUseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCase {
  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private GenerateTokenUseCase generateToken;

  public String execute(Restaurant data) {
    this.restaurantRepository.findByEmail(data.getEmail()).ifPresent((restaurant) -> {
      throw new EmailAlreadyInUseException();
    });

    data.setPassword(passwordEncoder.encode(data.getPassword()));
    Restaurant newRestaurant = this.restaurantRepository.save(data);

    return this.generateToken.execute(newRestaurant);
  }
}
