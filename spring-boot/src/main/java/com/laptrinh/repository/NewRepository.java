package com.laptrinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinh.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
