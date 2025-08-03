package com.eon.order.service;

import com.eon.order.OrderMapper;
import com.eon.order.dto.OrderDTO;
import com.eon.order.dto.OrderDTOFromFE;
import com.eon.order.dto.UserDTO;
import com.eon.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eon.order.repo.OrderRepo;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
    @Autowired
    private SequenceGenerator sequenceGenerator;
    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails) {

        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        System.out.println("service L-27: "+newOrderId);
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        System.out.println("service L-29: "+userDTO);
        Order orderToBeSaved = new Order(newOrderId,orderDetails.getFoodItemList(),orderDetails.getRestaurant(),userDTO);
                // Order(Integer orderId, List<FoodItemDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO)

        System.out.println("service L-33 save order: "+orderToBeSaved);
        orderRepo.save(orderToBeSaved);

        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    // we need to hit microservice
    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        System.out.println("service L-39");
        return restTemplate.getForObject("http://userService/user/fetchUserById/" + userId, UserDTO.class);
    }


}
