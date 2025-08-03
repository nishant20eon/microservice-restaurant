package com.eon.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eon.foodcatalogue.dto.FoodCataloguePage;
import com.eon.foodcatalogue.dto.FoodItemDTO;
import com.eon.foodcatalogue.dto.Restaurant;
import com.eon.foodcatalogue.entity.FoodItem;
import com.eon.foodcatalogue.mapper.FoodItemMapper;
import com.eon.foodcatalogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {

	@Autowired
	private FoodItemRepo foodItemRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		// TODO Auto-generated method stub
		FoodItem save = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(save);
	}

	public FoodCataloguePage fetchFoodcataloguePageDetails(Integer restaurantId) {
		// FoodCataloguePage = List<FoodItem> + Restaurant

		// food item list of restaurantId
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		
		// restaurantdetails
		Restaurant restaurant =  fetchResaurantDeatilsFromREstaurantMS(restaurantId);
		
		// finally createcataloguePage
		FoodCataloguePage finalFoodCatalogue = createcataloguePage(foodItemList,restaurant);
		
		return finalFoodCatalogue;
		// TODO Auto-generated method stub
		
	}

	private FoodCataloguePage createcataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		// TODO Auto-generated method stub
		
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		
		foodCataloguePage.setFoodItemList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;
	}

	private Restaurant fetchResaurantDeatilsFromREstaurantMS(Integer restaurantId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://RESTAURANT-LISTING-PROJECT/restaurant/fetchById/"+restaurantId, Restaurant.class);
		
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		// TODO Auto-generated method stub
		return foodItemRepo.findByRestaurantId(restaurantId);
	}
}
