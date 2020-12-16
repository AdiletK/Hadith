package com.tezal.hadith.controller

import com.tezal.hadith.model.auth.AuthRequest
import com.tezal.hadith.model.auth.AuthResponse
import com.tezal.hadith.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authService: AuthService) {
    @PostMapping("/signin")
    fun login(@RequestBody user: AuthRequest): AuthResponse {
        return AuthResponse(authService.signin(user.username, user.password))
    }

//    @PostMapping("/signup")
//    fun signUP(@RequestBody userDto: UserDto?): String {
//        return authService.signUp(userDto)
//    }
}