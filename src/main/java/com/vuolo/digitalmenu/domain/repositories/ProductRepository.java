package com.vuolo.digitalmenu.domain.repositories;

import com.vuolo.digitalmenu.domain.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  List<Product> findAll();

  List<Product> findByRestaurantId(String restaurantId);

  Optional<Product> findById(String id);

  Optional<Product> findByIdAndRestaurantId(String id, String restaurantId);

  Product save(Product product);

  void deleteById(String id);
}
