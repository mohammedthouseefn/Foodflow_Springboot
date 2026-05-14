package com.foodflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodflow.entity.Food;
import com.foodflow.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodCtrl {
	
	@Autowired
	FoodService foodService;
	
	@PostMapping
	public Food saveFood(@RequestBody Food food)
	{
		return foodService.sava(food);
	}
	
	@GetMapping
	public List<Food> getAllFood()
	{
		return foodService.getAllFood();
	}

}
