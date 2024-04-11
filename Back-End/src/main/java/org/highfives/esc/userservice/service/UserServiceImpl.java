package org.highfives.esc.userservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.highfives.esc.userservice.aggregate.UserEntity;
import org.highfives.esc.userservice.dto.UserDTO;
import org.highfives.esc.userservice.repository.UserRepository;
import org.highfives.esc.userservice.security.JwtUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Environment environment;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, Environment environment) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.environment = environment;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        System.out.println(users);
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void registUser(UserDTO userDTO) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        userRepository.save(userEntity);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null)
            throw new UsernameNotFoundException(email + ": not found");

        return new User(userEntity.getEmail(), userEntity.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }

    @Override
    public UserDTO getUserDetailsByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null)
            throw new UsernameNotFoundException(email + " 아이디의 유저는 존재하지 않음");

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        System.out.println(userDTO);
        return userDTO;
    }

    @Override
    public Claims getTokenInfo(String token) {
        Claims claims = parseClaims(token);
        System.out.println(claims.getSubject());
        System.out.println(claims.get("userNickname"));


        return claims;
    }

    public Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(environment.getProperty("token.secret")).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    @Override
    public UserDTO getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findById(Long.valueOf(userId)).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserDTO userDTO = new ModelMapper().map(userEntity, UserDTO.class);

        return userDTO;
    }

    @Override
    public String emailCheck(String email) {
        String check;
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null){
            check = "true";
        } else check = "false";

        return check;
    }


}
