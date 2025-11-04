package com.zytoame.patchtreatmentrearend.controller;

import com.zytoame.patchtreatmentrearend.common.Result;
import com.zytoame.patchtreatmentrearend.dto.LoginRequest;
import com.zytoame.patchtreatmentrearend.dto.LoginResponse;
import com.zytoame.patchtreatmentrearend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        try{
            LoginResponse loginResponse = authService.login(request);
            return Result.success("登录成功",loginResponse);
        }catch (Exception e){
            log.error("登录失败：{}",e.getMessage());
            return Result.fail(401,e.getMessage());
        }
    }
}
