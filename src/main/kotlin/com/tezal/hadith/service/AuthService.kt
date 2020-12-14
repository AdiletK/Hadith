package com.tezal.hadith.service

import com.tezal.hadith.exception.CustomException
import com.tezal.hadith.repo.UserRepo
import com.tezal.hadith.security.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

//import com.tezal.hadith.model.dto.UserDto;
@Service
class AuthService {
    @Autowired
    private val userRepository: UserRepo? = null

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Autowired
    private val jwtTokenProvider: JwtTokenProvider? = null

    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    fun signin(username: String?, password: String?): String {
        return try {
            authenticationManager!!.authenticate(UsernamePasswordAuthenticationToken(username, password))
            val (_, _, _, _, roles) = userRepository!!.findByUserName(username!!)
            jwtTokenProvider!!.createToken(username, roles)
        } catch (e: AuthenticationException) {
            throw CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY)
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
    fun refresh(username: String?): String {
        return jwtTokenProvider!!.createToken(username, userRepository!!.findByUserName(username!!).roles)
    }
}