package com.unac.salescarpremium.services.interfaces;

import com.unac.salescarpremium.dtos.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAllUsers();
    Optional<UserDTO> findUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
}
