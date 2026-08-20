package com.example.CRUD.controllers;

import com.example.CRUD.domain.product.Product;
import com.example.CRUD.domain.product.ProductRepository;
import com.example.CRUD.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping //cadastra o produto
    public ResponseEntity<Product> registerProduct(@RequestBody @Valid RequestProduct data) {
        Product product = new Product(data);

        repository.save(product);

        return ResponseEntity.ok().build();
    }

    @PutMapping // atualizar um dado
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid RequestProduct data) {
        Product product = repository.getReferenceById(data.id());
        product.setDescription(data.description());
        product.setName(data.name());
        product.setCategory(data.category());
        product.setTechnology(data.technology());

        repository.save(product);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}