package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.model.Reduction;

import java.util.ArrayList;
import java.util.Date;

public interface ReductionDataAccess {
    ArrayList<Reduction> getReductionByStartDate(Date date);
}
