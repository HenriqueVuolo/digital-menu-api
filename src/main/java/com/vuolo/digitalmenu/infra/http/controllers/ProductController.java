package com.vuolo.digitalmenu.infra.http.controllers;

import com.vuolo.digitalmenu.domain.entities.Product;
import com.vuolo.digitalmenu.infra.http.dto.CreateProductRequestDto;
import com.vuolo.digitalmenu.infra.http.dto.UpdateProductRequestDto;
import com.vuolo.digitalmenu.use_cases.product.CreateProductUseCase;
import com.vuolo.digitalmenu.use_cases.product.DeleteProductUseCase;
import com.vuolo.digitalmenu.use_cases.product.GetProductsUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  GetProductsUseCase getProducts;

  @Autowired
  CreateProductUseCase createProduct;

  @Autowired
  DeleteProductUseCase deleteProduct;

  @GetMapping
  public ResponseEntity<Object> getProducts(HttpServletRequest request) {
    try {
      String restaurantId = request.getAttribute("restaurantId").toString();
      List<Product> products = this.getProducts.execute(restaurantId);
      return ResponseEntity.ok().body(products);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<Object> createProduct(@Valid @RequestBody CreateProductRequestDto body,
      HttpServletRequest request) {
    try {
      String restaurantId = request.getAttribute("restaurantId").toString();
      Product newProduct = this.createProduct
          .execute(Product.builder()
              .name(body.name())
              .image(body.image())
              .price(body.price())
              .description(body.description())
              .restaurantId(restaurantId)
              .build());
      return ResponseEntity.ok().body(newProduct);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PatchMapping
  public ResponseEntity<Object> updateProduct(@PathVariable String productId,
      @Valid @RequestBody UpdateProductRequestDto body,
      HttpServletRequest request) {
    try {
      String restaurantId = request.getAttribute("restaurantId").toString();
      Product newProduct = this.createProduct
          .execute(Product.builder()
              .id(productId)
              .name(body.name())
              .image(body.image())
              .price(body.price())
              .description(body.description())
              .restaurantId(restaurantId)
              .build());
      return ResponseEntity.ok().body(newProduct);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Object> deleteProduct(@PathVariable String productId, HttpServletRequest request) {
    try {
      this.deleteProduct.execute(Product.builder()
          .id(productId)
          .restaurantId(request.getAttribute("restaurantId").toString())
          .build());
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
