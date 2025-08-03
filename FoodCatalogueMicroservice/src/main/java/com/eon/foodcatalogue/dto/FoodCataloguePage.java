package com.eon.foodcatalogue.dto;

import java.util.List;

import com.eon.foodcatalogue.entity.FoodItem;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodCataloguePage {
	@JsonProperty("foodItemsList")
	private List<FoodItem> foodItemList;
	private Restaurant restaurant;
	public List<FoodItem> getFoodItemList() {
		return foodItemList;
	}
	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemList = foodItemList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public FoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		super();
		this.foodItemList = foodItemList;
		this.restaurant = restaurant;
	}
	public FoodCataloguePage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FoodCataloguePage [foodItemList=" + foodItemList + ", restaurant=" + restaurant + "]";
	}
	
	

}
