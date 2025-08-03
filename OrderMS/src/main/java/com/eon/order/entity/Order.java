package com.eon.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.eon.order.dto.FoodItemDTO;
import com.eon.order.dto.Restaurant;
import com.eon.order.dto.UserDTO;

@Document("order")
public class Order {
	
	private Integer orderId;
	private List<FoodItemDTO> foodItemsList;
	private Restaurant restaurant;
	private UserDTO userDTO;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer orderId, List<FoodItemDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO) {
		super();
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
		this.userDTO = userDTO;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public List<FoodItemDTO> getFoodItemsList() {
		return foodItemsList;
	}
	public void setFoodItemsList(List<FoodItemDTO> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", foodItemsList=" + foodItemsList +
				", restaurant=" + restaurant +
				", userDTO=" + userDTO +
				'}';
	}
}
