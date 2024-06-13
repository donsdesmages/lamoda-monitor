package com.example.lamodamonitor.repository;

import com.example.lamodamonitor.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p.price FROM ProductEntity p WHERE p.sku = :sku")
    List<Long> findPriceBySku(@Param("sku") String sku);
}
