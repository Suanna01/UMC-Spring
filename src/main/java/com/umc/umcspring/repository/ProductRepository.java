package com.umc.umcspring.repository;

import com.umc.umcspring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name); // 상품 이름으로 상품 조회하기

    List<Product> findAll(); // 전체 조회하기

}
