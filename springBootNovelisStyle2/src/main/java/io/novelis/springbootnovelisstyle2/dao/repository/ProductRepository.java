package io.novelis.springbootnovelisstyle2.dao.repository;

import io.novelis.springbootnovelisstyle2.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
//SimpleJpaRepository class : the source of implementations
}
