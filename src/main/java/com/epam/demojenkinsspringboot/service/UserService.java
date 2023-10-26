package com.epam.demojenkinsspringboot.service;

import com.epam.demojenkinsspringboot.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO getUser(Long id);

    List<UserDTO> getAllUsers();

    void deleteUser(Long id);

}
