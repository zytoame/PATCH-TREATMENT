package com.zytoame.patchtreatmentrearend.repository;

import com.zytoame.patchtreatmentrearend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> , JpaSpecificationExecutor<Patient> {
    /**
     * 根据姓名查找病人（模糊查询
     * @param username
     * @return
     */
    List<Patient> findByName(String username);

    /**
     * 根据姓名和出生日期精确查找
     * @param name
     * @param dateOfBirth
     * @return
     */
    List<Patient> findByNameAndDateOfBirth(String name, LocalDate dateOfBirth);
}
