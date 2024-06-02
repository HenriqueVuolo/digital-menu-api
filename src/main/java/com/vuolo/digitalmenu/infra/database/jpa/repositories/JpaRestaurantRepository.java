package com.vuolo.digitalmenu.infra.database.jpa.repositories;

import com.vuolo.digitalmenu.domain.entities.Restaurant;
import com.vuolo.digitalmenu.domain.repositories.RestaurantRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface JpaRestaurantRepository extends RestaurantRepository, JpaRepository<Restaurant, String> {
    Optional<Restaurant> findByEmail(String email) throws UsernameNotFoundException;
}
