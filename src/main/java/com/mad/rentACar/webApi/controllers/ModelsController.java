package com.mad.rentACar.webApi.controllers;

import com.mad.rentACar.model.dtos.requests.CreateModelRequest;
import com.mad.rentACar.model.dtos.responses.GetAllModelsResponse;
import com.mad.rentACar.service.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    
    private ModelService modelService;
    
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
