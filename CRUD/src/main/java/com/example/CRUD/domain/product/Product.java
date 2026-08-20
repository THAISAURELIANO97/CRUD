package com.example.CRUD.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "products")
@Entity(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //gerado automaticamente
    private Integer id;

    private String name;

    private String description;

    private String category;

    private String technology;

    public Product(RequestProduct data) {
        this.id = data.id();
        this.name = data.name();
        this.description = data.description();
        this.category = data.category();
        this.technology = data.technology();
    }
}