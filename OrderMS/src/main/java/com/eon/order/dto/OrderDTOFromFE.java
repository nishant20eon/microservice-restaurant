package com.eon.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderDTOFromFE {
	@JsonProperty("foodItemsList") // ✅ this maps frontend's key to backend field
	private List<FoodItemDTO> foodItemList;
	
	private Integer userId;
	
	private Restaurant restaurant;

	public OrderDTOFromFE(List<FoodItemDTO> foodItemList, Integer userId, Restaurant restaurant) {
		super();
		this.foodItemList = foodItemList;
		this.userId = userId;
		this.restaurant = restaurant;
	}

	public OrderDTOFromFE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<FoodItemDTO> getFoodItemList() {
		return foodItemList;
	}

	public void setFoodItemList(List<FoodItemDTO> foodItemList) {
		this.foodItemList = foodItemList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "OrderDTOFromFE{" +
				"foodItemList=" + foodItemList +
				", userId=" + userId +
				", restaurant=" + restaurant +
				'}';
	}
}
