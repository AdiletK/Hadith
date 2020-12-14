package com.tezal.hadith.service;

import com.tezal.hadith.entity.UserEntity;
import com.tezal.hadith.enums.RoleList;
import com.tezal.hadith.enums.StatusList;
import com.tezal.hadith.exception.CustomException;
//import com.tezal.hadith.model.dto.UserDto;
import com.tezal.hadith.repo.UserRepo;
import com.tezal.hadith.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class AuthService {

  @Autowired
  private UserRepo userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  public String signin(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      UserEntity userEntity = userRepository.findByUserName(username);
      return jwtTokenProvider.createToken(username, userEntity.getRoles());
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

//  public String signUp(UserDto userDto){
//    UserEntity user = new UserEntity();
//    user.setUserName(userDto.getUserName());
//    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//    user.setStatus(StatusList.ENABLED);
//    user.setRoles(Collections.singletonList(RoleList.ROLE_CLIENT));
//    userRepository.save(user);
//    return jwtTokenProvider.createToken(user.getUserName(), user.getRoles());
//  }

  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userRepository.findByUserName(username).getRoles());
  }

}
