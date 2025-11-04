package com.zytoame.patchtreatmentrearend.service;

import com.zytoame.patchtreatmentrearend.dto.LoginRequest;
import com.zytoame.patchtreatmentrearend.dto.LoginResponse;
import com.zytoame.patchtreatmentrearend.entity.User;
import com.zytoame.patchtreatmentrearend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 认证服务类
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * 用户登录
     */
    public LoginResponse login(LoginRequest request) {
        try {
            //使用Spring Security进行认证
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            //认证成功后获取用户信息
            User user = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new RuntimeException("用户不存在"));

            //构建响应（暂时不生成Token）
            LoginResponse.LoginResponseBuilder builder = LoginResponse.builder();
            builder.access_token("tmp_token_" + user.getId());
            builder.token_type("Bearer");
            builder.expires_in(7200L);
            LoginResponse.LoginResponseBuilder loginResponseBuilder = builder.userInfo(LoginResponse.UserInfo.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .role(user.getRole())
                    .build());
            return builder
                    .build();
        }catch (AuthenticationException e){
            log.error("登录失败：{}", e.getMessage());
            throw new RuntimeException("用户名或密码错误");
        }
    }

    /**
     * 创建用户（用于初始化测试账户）
     */
    @Transactional
    public User createUser(String username, String password, String role) {
        if(userRepository.existsByUsername(username)){
            throw new RuntimeException("用户名已存在");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return userRepository.save(user);
    }
}
