package com.zytoame.patchtreatmentrearend.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 治疗记录实体类
 */
@Entity
@Table(name = "treatment_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "treatment_number", nullable = false)
    private Integer treatmentNumber; // 治疗次数

    @Column(name = "treatment_date", nullable = false)
    private LocalDate treatmentDate;

    @Column(name = "treatment_duration", nullable = false, precision = 5, scale = 2)
    private BigDecimal treatmentDuration; // 治疗时长（小时）

    @Column(name = "lesion_location", nullable = false, length = 50)
    private String lesionLocation; // 病灶位置

    @Column(name = "drug_activity", length = 100)
    private String drugActivity; // 药物活性

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes; // 备注

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    //关联病人（多对一）
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;

    //关联照片（一对多）
    @OneToMany(mappedBy = "treatmentRecordId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TreatmentPhoto> photos = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
