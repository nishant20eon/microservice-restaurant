package com.eon.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eon.restaurant.dto.RestaurantDTO;
import com.eon.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
// to get data from front end, request from from end will not work
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }
    // http://localhost:9091/restaurant/create
    @PostMapping("/create")
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO dto) {
        RestaurantDTO saved = restaurantService.createRestaurant(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id) {
       return restaurantService.fetchRestaurantById(id);
    }
    
    
    
    


}
