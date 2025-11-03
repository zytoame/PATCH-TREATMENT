package com.zytoame.patchtreatmentrearend.repository;

import com.zytoame.patchtreatmentrearend.entity.Patient;
import com.zytoame.patchtreatmentrearend.entity.TreatmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 治疗记录接口
 */
@Repository
public interface TreatmentRecordRepository extends JpaRepository<TreatmentRecord, Long> {
    /**
     * 根据病人ID查找所有治疗记录
     * @param patientId
     * @return
     */
    List<TreatmentRecord> findByPatientIdOrderByTreatmentDateDesc(Long patientId);

    /**
     * 统计病人的治疗记录总数
     * @param patientId
     * @return
     */
    @Query("select count(t) from TreatmentRecord t WHERE t.patientId = :patientId")
    long countByPatientId(@Param("patientId") Long patientId);

    /**
     * 获取某病人的最大治疗次数
     * @param treatmentRecordId
     * @return
     */
    @Query("SELECT MAX (t.treatmentNumber) from TreatmentRecord t where t.patientId = :patientId")
    Integer countByTreatmentRecordId(@Param("patientId") Long treatmentRecordId);
}
