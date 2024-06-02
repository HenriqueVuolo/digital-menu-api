package com.vuolo.digitalmenu.use_cases.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuolo.digitalmenu.domain.entities.Product;
import com.vuolo.digitalmenu.domain.repositories.ProductRepository;
import com.vuolo.digitalmenu.exceptions.ProductNotFoundException;

@Service
public class UpdateProductUseCase {
  @Autowired
  private ProductRepository productRepository;

  public Product execute(Product data) {
    Product product = this.productRepository.findByIdAndRestaurantId(data.getId(), data.getRestaurantId())
        .orElseThrow(() -> new ProductNotFoundException());

    String name = data.getName();
    String image = data.getImage();
    String description = data.getDescription();
    Double price = data.getPrice();

    if (name != null) {
      product.setName(name);
    }

    if (image != null) {
      product.setImage(image);
    }

    if (description != null) {
      product.setDescription(description);
    }

    if (price != null) {
      product.setPrice(price);
    }

    return this.productRepository.save(product);
  }
}
