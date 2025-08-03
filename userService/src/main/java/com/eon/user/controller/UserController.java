package com.eon.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eon.user.dto.UserDTO;
import com.eon.user.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserDTO>> fetchAllUsers(){
        List<UserDTO> allUsers = userService.findAllusers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
    	UserDTO saved = userService.createUser(userDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    

    
	@GetMapping("/fetchUserById/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

}
