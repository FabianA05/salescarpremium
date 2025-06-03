package com.unac.salescarpremium.services.impl;

import com.unac.salescarpremium.dao.UserDAO;
import com.unac.salescarpremium.dtos.UserDTO;
import com.unac.salescarpremium.entities.User;
import com.unac.salescarpremium.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> findAllUsers() {
        return userDAO.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findUserById(Long id) {
        Optional<User> userOptional = userDAO.findById(id);
        return userOptional.map(user -> modelMapper.map(user, UserDTO.class));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userDAO.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }
}