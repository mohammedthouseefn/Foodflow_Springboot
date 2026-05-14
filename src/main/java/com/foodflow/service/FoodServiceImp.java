package com.foodflow.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodflow.entity.Food;
import com.foodflow.repository.FoodRepository;

@Service
public class FoodServiceImp implements FoodService {
	
	@Autowired
	FoodRepository foodRepository;

	@Override
	public Food sava(Food food) {
		return foodRepository.save(food);
	}

	@Override
	public List<Food> getAllFood() {
		List<Food> val1 = new ArrayList<>();
		List<Food> val = foodRepository.findAll();
		//sorted by price
		val1 = val.stream().sorted(Comparator.comparingDouble(Food::getPrice)).toList(); 
		val1 = new ArrayList<>();
		//second Highest
		Double secondhigh = val.stream().map(Food::getPrice).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
		Food val2 = val.stream().filter(x-> x.getPrice()==secondhigh).findFirst().orElseGet(null); 
		val1.add(val2);
		//category based Highest price
		val1 = new ArrayList<>();
		val1 = val.stream().collect(Collectors.groupingBy(Food::getCategory)).values()
				.stream().map(food -> food.stream()
//						.sorted(Comparator.comparing(Food::getPrice).reversed())
						.min(Comparator.comparingDouble(Food::getPrice)).orElse(null))
				.filter(Objects::nonNull).toList(); 
//		val1 = val.stream().skip(3).toList();
		return val;
	}

}
