package com.dss.p2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dss.p2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// https://docs.spring.io/spring-data/jpa/docs/2.6.0/reference/html/#jpa.repositories

}
