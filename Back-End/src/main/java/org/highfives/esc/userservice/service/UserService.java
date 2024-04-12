package org.highfives.esc.userservice.service;

import io.jsonwebtoken.Claims;
import org.highfives.esc.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDTO> getAllUsers();

    void registUser(UserDTO userDTO);

    UserDTO getUserDetailsByEmail(String email);

    Claims getTokenInfo(String token);

    UserDTO getUserByUserId(String userId);

    String emailCheck(String email);

    String nicknameCheck(String nickname);

    String findUserEmail(String name, String nickname);

    String emailExCheck(String email);

    String checkUserEx(String name, String email);
}
