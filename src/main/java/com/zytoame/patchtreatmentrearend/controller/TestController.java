package com.zytoame.patchtreatmentrearend.controller;

import com.zytoame.patchtreatmentrearend.common.Result;
import com.zytoame.patchtreatmentrearend.entity.Patient;
import com.zytoame.patchtreatmentrearend.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
//@RequiredArgsConstructor
public class TestController {
    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/patients")
    public Result<List<Patient>> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return Result.success(patients);
    }
    // 添加一个简单的测试接口
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("Hello, Spring Boot is working!");
    }
}
