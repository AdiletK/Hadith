package com.tezal.hadith.controller;

import com.tezal.hadith.model.dto.UserDto;
import com.tezal.hadith.service.AuthService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signin")
    public String login(@ApiParam("Username") @RequestParam String username,
                        @ApiParam("Password") @RequestParam String password) {
        return authService.signin(username, password);
    }
    @PostMapping("/signup")
    public String signUP(@RequestBody UserDto userDto) {
        return authService.signUp(userDto);
    }



}
