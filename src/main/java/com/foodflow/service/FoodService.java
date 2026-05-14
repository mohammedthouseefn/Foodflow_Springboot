package com.foodflow.service;

import java.util.List;

import com.foodflow.entity.Food;

public interface FoodService {

	Food sava(Food food);

	List<Food> getAllFood();

}
