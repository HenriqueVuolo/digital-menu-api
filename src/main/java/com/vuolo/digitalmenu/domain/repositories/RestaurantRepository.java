package com.vuolo.digitalmenu.domain.repositories;

import com.vuolo.digitalmenu.domain.entities.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
  Restaurant save(Restaurant restaurant);

  Optional<Restaurant> findById(String id);

  Optional<Restaurant> findByEmail(String email);
}
