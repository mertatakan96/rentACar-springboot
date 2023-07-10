package com.mad.rentACar.service;

import com.mad.rentACar.model.dtos.requests.CreateModelRequest;
import com.mad.rentACar.model.dtos.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
    
}
