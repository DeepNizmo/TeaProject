package com.spring.henallux.teaProject.dataAccess.repository;

import com.spring.henallux.teaProject.dataAccess.entity.ReductionEntity;
import com.spring.henallux.teaProject.model.Reduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ReductionRepository extends JpaRepository<ReductionEntity, Reduction> {
    List<ReductionEntity> findByPromotion_StartDateLessThanEqualAndPromotion_EndDateGreaterThanEqual(Date startDate, Date endDate);
}
