package com.eon.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.eon.user.dto.UserDTO;
import com.eon.user.entity.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);

   UserDTO mapUserToUserDTO(User user);
}
