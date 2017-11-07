package com.onik.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onik.entity.Outlet;
import com.onik.entity.Product;
import com.onik.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	Collection<Stock> findByOutlet(Outlet outlet);
	Collection<Stock> findByProduct(Product product);
	Stock findByOutletAndProduct(Outlet outlet, Product product);
}
