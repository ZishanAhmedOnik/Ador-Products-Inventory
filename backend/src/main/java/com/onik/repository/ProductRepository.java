package com.onik.repository;

import com.onik.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by onik on 1/7/17.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
