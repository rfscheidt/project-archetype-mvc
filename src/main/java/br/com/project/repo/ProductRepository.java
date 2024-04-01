package br.com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
