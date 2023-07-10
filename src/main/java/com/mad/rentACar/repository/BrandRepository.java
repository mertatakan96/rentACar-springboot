package com.mad.rentACar.repository;

import com.mad.rentACar.model.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
    
    boolean existsByName(String name);
}
