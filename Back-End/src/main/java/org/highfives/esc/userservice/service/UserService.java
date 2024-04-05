package org.highfives.esc.userservice.service;

import org.highfives.esc.userservice.dto.UserDTO;


import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
}
