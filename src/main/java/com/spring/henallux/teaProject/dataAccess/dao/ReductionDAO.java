package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.teaProject.dataAccess.entity.ReductionEntity;
import com.spring.henallux.teaProject.dataAccess.repository.ReductionRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.Reduction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReductionDAO implements ReductionDataAccess{
    private ReductionRepository reductionRepository;
    private ProviderConverter providerConverter;

    public ReductionDAO(ReductionRepository reductionRepository, ProviderConverter providerConverter) {
        this.reductionRepository = reductionRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Reduction> getReductionByStartDate(Date date) {
//        Date today = new Date();
//        //List<ReductionEntity> reductionEntities = reductionRepository.findByPromotion_StartDateGreaterThanEqualAndPromotion_EndDateLessThanEqual(new java.sql.Date(today.getTime()));
//        ArrayList<Reduction> reductions = new ArrayList<>();
//        for (ReductionEntity reductionEntity : reductionEntities) {
//            Reduction reduction = providerConverter.reductionEntityToReductionModel(reductionEntity);
//            reductions.add(reduction);
//        }
        return null;
    }
}
