package com.eon.restaurant.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eon.restaurant.dto.RestaurantDTO;
import com.eon.restaurant.entity.Restaurant;
import com.eon.restaurant.mapper.RestaurantMapper;
import com.eon.restaurant.repo.RestaurantRepo;


@Service
public class RestaurantService {
//    private final RestaurantMapper mapper = RestaurantMapper.INSTANCE;
    private static final Logger logger = LoggerFactory.getLogger(RestaurantService.class);
    @Autowired
    RestaurantRepo restaurantRepo;
    
    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        restaurants.stream().forEach(r->System.out.println(r.toString()));
        List<RestaurantDTO> restaurantDTOList = restaurants.stream()
        		.map(restaurant -> RestaurantMapper.INSTANCE
        				.mapRestaurantToRestaurantDTO(restaurant))
        				.collect(Collectors.toList());
        return restaurantDTOList;
    }

    public RestaurantDTO createRestaurant(RestaurantDTO dto) {
    	System.out.println(dto.toString());
    	Restaurant save = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(dto));
    	
    	return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(save);
    }
    
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant =  restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
