package com.foodflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodflow.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
