package com.zytoame.patchtreatmentrearend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 治疗照片实体类
 */
@Entity
@Table(name = "treatment_photo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "treatment_record_id", nullable = false)
    private Long treatmentRecordId;

    @Column(name = "photo_path", nullable = false, length = 500)
    private String photoPath; // 照片存储路径

    @Column(name = "photo_name", nullable = false, length = 255)
    private String photoName; // 照片原始名称

    @Column(name = "file_size", nullable = false)
    private Long fileSize; // 文件大小（字节）

    @Column(name = "thumbnail_path", length = 500)
    private String thumbnailPath; // 缩略图路径

    @Column(name = "upload_time", nullable = false, updatable = false)
    private LocalDateTime uploadTime;

    //关联治疗记录（多对一）
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_record_id", insertable = false, updatable = false)
    private TreatmentRecord treatmentRecord;

    @PrePersist
    protected void onCreate() {
        uploadTime = LocalDateTime.now();
    }
}
