package org.highfives.esc.userservice.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.highfives.esc.userservice.dto.UserDTO;
import org.highfives.esc.userservice.service.UserService;
import org.highfives.esc.userservice.vo.ResponseUser;
import org.highfives.esc.userservice.vo.RigistUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private Environment env;

    private ModelMapper modelMapper;

    private UserService userService;

    @Autowired
    public UserController(Environment env, ModelMapper modelMapper, UserService userService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/regist")
    public ResponseEntity<ResponseUser> registUser(@RequestBody RigistUser userInfo) {
        UserDTO userDTO = modelMapper.map(userInfo, UserDTO.class);
        userService.registUser(userDTO);

        ResponseUser responseUser = modelMapper.map(userDTO, ResponseUser.class);


        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/tokenInfo/{token}")
    public Claims getTokenInfo(@PathVariable("token") String token) {
        return userService.getTokenInfo(token);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUser(@PathVariable("userId") String userId) {
        UserDTO userDTO = userService.getUserByUserId(userId);

        ResponseUser returnValue = new ModelMapper().map(userDTO, ResponseUser.class);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }



}
