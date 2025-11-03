package com.zytoame.patchtreatmentrearend.repository;

import com.zytoame.patchtreatmentrearend.entity.TreatmentPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentPhotoRepository extends JpaRepository<TreatmentPhoto, Long> {
    List<TreatmentPhoto> findByTreatmentRecordIdOrderByUploadTimeAsc(Long treatmentRecordId);
}
