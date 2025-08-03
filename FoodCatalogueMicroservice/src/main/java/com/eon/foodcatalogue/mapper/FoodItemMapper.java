package com.eon.foodcatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.eon.foodcatalogue.dto.FoodItemDTO;
import com.eon.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
	
	FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
	
	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
}
