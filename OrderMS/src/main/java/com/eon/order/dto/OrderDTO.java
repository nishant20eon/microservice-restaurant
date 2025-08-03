package com.eon.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderDTO {

	private Integer orderId;
	@JsonProperty("foodItemsList")
	private List<FoodItemDTO> foodItemsList;
	private Restaurant restaurant;
	private UserDTO userDTO;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(Integer orderId, List<FoodItemDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO) {
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
}
