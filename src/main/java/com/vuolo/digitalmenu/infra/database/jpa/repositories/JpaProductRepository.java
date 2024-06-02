package com.vuolo.digitalmenu.infra.database.jpa.repositories;

import com.vuolo.digitalmenu.domain.entities.Product;
import com.vuolo.digitalmenu.domain.repositories.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, String> {
    List<Product> findByRestaurantId(String restaurantId);

    Optional<Product> findByIdAndRestaurantId(String id, String restaurantId);
}
