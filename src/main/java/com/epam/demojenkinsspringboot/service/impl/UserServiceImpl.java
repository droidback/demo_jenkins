package com.epam.demojenkinsspringboot.service.impl;

import com.epam.demojenkinsspringboot.dto.UserDTO;
import com.epam.demojenkinsspringboot.exception.DataNotFoundException;
import com.epam.demojenkinsspringboot.mapper.UserMapper;
import com.epam.demojenkinsspringboot.model.User;
import com.epam.demojenkinsspringboot.repository.UserRepository;
import com.epam.demojenkinsspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User model = userMapper.toModel(userDTO);
        User savedModel = repository.save(model);
        return userMapper.toDTO(savedModel);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = repository.findById(userDTO.getId())
                .orElseThrow(() -> new DataNotFoundException("User", " id ", userDTO.getId()));

        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPassword(userDTO.getPassword());

        User updatedUser = repository.save(user);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public UserDTO getUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User", "Id", id));

        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = repository.findAll();
        return userMapper.toUserDTOs(users);
    }

    @Override
    public void deleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User", "Id", id));

        repository.delete(user);
    }
}
