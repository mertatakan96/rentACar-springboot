package com.mad.rentACar.service;

import com.mad.rentACar.core.utilities.mappers.ModelMapperService;
import com.mad.rentACar.model.dtos.requests.CreateModelRequest;
import com.mad.rentACar.model.dtos.responses.GetAllModelsResponse;
import com.mad.rentACar.model.entities.Model;
import com.mad.rentACar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
    
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    
    @Override
    public List<GetAllModelsResponse> getAll() {
        
        List<Model> models = modelRepository.findAll();
        
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                .map(model, GetAllModelsResponse.class)).toList();
                
        
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        
        this.modelRepository.save(model);
    }
}
