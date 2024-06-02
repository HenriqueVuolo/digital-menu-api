package com.vuolo.digitalmenu.use_cases.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuolo.digitalmenu.domain.entities.Product;
import com.vuolo.digitalmenu.domain.repositories.ProductRepository;
import com.vuolo.digitalmenu.exceptions.ProductNotFoundException;

@Service
public class DeleteProductUseCase {
  @Autowired
  private ProductRepository productRepository;

  public void execute(Product data) {
    this.productRepository.findByIdAndRestaurantId(data.getId(), data.getRestaurantId())
        .orElseThrow(() -> new ProductNotFoundException());
    this.productRepository.deleteById(data.getId());
  }

}
