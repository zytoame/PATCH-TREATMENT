package com.zytoame.patchtreatmentrearend.common;

/**
 * 用户角色枚举
 */
public enum Role {
    ADMIN("ADMIN", "管理员"),
    DOCTOR("DOCTOR", "医生"),
    NURSE("NURSE", "护士");

    private final String code;
    private final String description;

    Role(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Role fromCode(String code) {
        for (Role role : values()) {
            if (role.code.equals(code)) {
                return role;
            }
        }
        throw new IllegalArgumentException("未知的角色代码: " + code);
    }
}
