package org.highfives.esc.userservice.service;

import org.highfives.esc.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDTO> getAllUsers();

    UserDTO registUser(UserDTO userDTO);

    UserDTO getUserDetailsByEmail(String email);
}
