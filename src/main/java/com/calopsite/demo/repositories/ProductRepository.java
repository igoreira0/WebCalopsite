package com.calopsite.demo.repositories;

import com.calopsite.demo.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
