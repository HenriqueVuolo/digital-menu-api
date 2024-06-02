package com.vuolo.digitalmenu.use_cases.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuolo.digitalmenu.domain.entities.Product;
import com.vuolo.digitalmenu.domain.repositories.ProductRepository;

@Service
public class CreateProductUseCase {
  @Autowired
  private ProductRepository productRepository;

  public Product execute(Product data) {
    return this.productRepository.save(data);
  }
}
