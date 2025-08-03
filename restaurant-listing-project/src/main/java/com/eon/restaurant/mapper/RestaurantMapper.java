package com.eon.restaurant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.eon.restaurant.dto.RestaurantDTO;
import com.eon.restaurant.entity.Restaurant;
@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
