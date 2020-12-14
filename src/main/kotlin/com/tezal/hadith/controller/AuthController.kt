package com.tezal.hadith.controller

import com.tezal.hadith.service.AuthService
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authService: AuthService) {
    @PostMapping("/signin")
    fun login(@ApiParam("Username") @RequestParam username: String?,
              @ApiParam("Password") @RequestParam password: String?): String {
        return authService.signin(username, password)
    }

//    @PostMapping("/signup")
//    fun signUP(@RequestBody userDto: UserDto?): String {
//        return authService.signUp(userDto)
//    }
}