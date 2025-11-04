package com.zytoame.patchtreatmentrearend.config;

import com.zytoame.patchtreatmentrearend.repository.UserRepository;
import com.zytoame.patchtreatmentrearend.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化测试用户（仅开发环境使用）
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class InitUserConfig implements CommandLineRunner {
    private final AuthService authService;
    private final UserRepository userRepository;

    @Override
    public void run(String... args){
        //只有在用户不存在时创建
        if(userRepository.count() == 0){
            log.info("开始初始化测试用户...");
            try {
                authService.createUser("admin1","123","ADMIN");
                log.info("创建管理员账号：admin/123");

                // 创建医生账户
                authService.createUser("doctor1", "doctor123", "DOCTOR");
                log.info("创建医生账户: doctor/ doctor123");

                // 创建护士账户
                authService.createUser("nurse1", "nurse123", "NURSE");
                log.info("创建护士账户: nurse / nurse123");

                log.info("测试用户初始化完成！");
            }catch (Exception e){
                log.error("初始化用户失败：{}",e.getMessage());
            }
        }else{
            log.info("用户已存在，跳过初始化");
        }
    }
}
