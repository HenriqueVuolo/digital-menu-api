package com.vuolo.digitalmenu.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Table(name = "product")
@Entity(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @NotNull()
  private String name;

  @NotNull()
  private String image;

  @NotNull()
  private double price;

  @Length(max = 500)
  private String description;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", insertable = false, updatable = false)
  private Restaurant restaurant;

  @Column(name = "restaurant_id", nullable = false)
  private String restaurantId;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  public Product(String name, String image, Double price, String description, String restaurantId) {
    this.name = name;
    this.image = image;
    this.price = price;
    this.description = description;
    this.restaurantId = restaurantId;
  }
}
