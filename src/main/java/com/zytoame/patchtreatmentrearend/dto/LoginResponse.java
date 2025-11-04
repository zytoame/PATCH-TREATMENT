package com.zytoame.patchtreatmentrearend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录响应DTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String access_token;          //访问令牌
    private String refresh_token; //刷新令牌（后续实现）
    private String token_type = "Bearer"; //令牌类型
    private Long expires_in;              //过期时间（秒）
    private UserInfo userInfo; //用户信息

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserInfo {
        private Long id;
        private String username;
        private String role;
    }
}
