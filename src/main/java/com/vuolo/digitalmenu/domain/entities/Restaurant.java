package com.vuolo.digitalmenu.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Table(name = "restaurant")
@Entity(name = "restaurant")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @NotNull()
  private String name;

  @Email(message = "E-mail inválido")
  @NotNull()
  private String email;

  @NotNull()
  private String password;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  public Restaurant(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public Restaurant(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
