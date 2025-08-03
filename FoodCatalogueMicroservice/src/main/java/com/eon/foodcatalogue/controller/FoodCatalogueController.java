package com.eon.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eon.foodcatalogue.dto.FoodCataloguePage;
import com.eon.foodcatalogue.dto.FoodItemDTO;
import com.eon.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodcatalogue")
@CrossOrigin
public class FoodCatalogueController {

	@Autowired
	private FoodCatalogueService foodCatalogueService;

	// add food item to database with restaurant id

	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {

		FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);

		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}
	// http://localhost:9093/foodcatalogue/fetchRestaurantAndFoodItemsById/2
	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodCataloguePage> fetchRestaurantDEtailsWithFoodMenu
													(@PathVariable Integer restaurantId) {
		FoodCataloguePage FoodCataloguePage = foodCatalogueService.fetchFoodcataloguePageDetails(restaurantId);
		return new ResponseEntity<FoodCataloguePage> (FoodCataloguePage, HttpStatus.OK);
	}

}
