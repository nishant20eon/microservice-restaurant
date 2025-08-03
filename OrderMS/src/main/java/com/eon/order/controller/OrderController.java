package com.eon.order.controller;

import com.eon.order.dto.OrderDTO;
import com.eon.order.dto.OrderDTOFromFE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eon.order.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	// i need to save data in mongo db
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails) {
		System.out.println("controller L-21"+orderDetails);
		OrderDTO orderDTO = orderService.saveOrderInDB(orderDetails);
		System.out.println("controller L-23"+orderDTO);
		return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
	}

	@GetMapping("/demo")
	public String demo() {
		System.out.println("coming here");
		return "hello";
	}

}
