package com.eon.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eon.user.dto.UserDTO;
import com.eon.user.entity.User;
import com.eon.user.mapper.UserMapper;
import com.eon.user.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public List<UserDTO> findAllusers() {
		// TODO Auto-generated method stub
        List<User> users = userRepo.findAll();

        List<UserDTO> UserDTOList = users.stream()
        		.map(user -> UserMapper.INSTANCE
        				.mapUserToUserDTO(user))
        				.collect(Collectors.toList());
        return UserDTOList;
	}

	public UserDTO createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
    	User save = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
    	
    	return UserMapper.INSTANCE.mapUserToUserDTO(save);
	}

	public ResponseEntity<UserDTO> getUserById(Integer id) {
		// TODO Auto-generated method stub
        Optional<User> user =  userRepo.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
