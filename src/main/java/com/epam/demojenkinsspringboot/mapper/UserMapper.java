package com.epam.demojenkinsspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.epam.demojenkinsspringboot.dto.UserDTO;
import com.epam.demojenkinsspringboot.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User toModel(UserDTO userDTO);

    List<User> toUsers(List<UserDTO> userDTOList);

    List<UserDTO> toUserDTOs(List<User> userList);
}
