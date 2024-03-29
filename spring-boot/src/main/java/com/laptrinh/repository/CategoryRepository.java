package com.laptrinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinh.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findOneByCode(String code);

}
