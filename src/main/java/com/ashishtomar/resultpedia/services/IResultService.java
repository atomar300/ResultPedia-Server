package com.ashishtomar.resultpedia.services;

import com.ashishtomar.resultpedia.dto.ResultDTO;
import com.ashishtomar.resultpedia.models.Result;

import java.util.List;

public interface IResultService {

    void createOrUpdateResult(ResultDTO resultDTO);
    List<Result> getAllResults();
    Result getSingleResult(String id);
    void deleteResult(String id);
}
