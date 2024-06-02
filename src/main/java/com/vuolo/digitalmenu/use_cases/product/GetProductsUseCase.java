package com.vuolo.digitalmenu.use_cases.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuolo.digitalmenu.domain.entities.Product;
import com.vuolo.digitalmenu.domain.repositories.ProductRepository;

@Service
public class GetProductsUseCase {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> execute(String restaurantId) {
    return this.productRepository.findByRestaurantId(restaurantId);
  }
}
