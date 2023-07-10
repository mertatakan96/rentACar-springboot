package com.mad.rentACar.repository;

import com.mad.rentACar.model.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
