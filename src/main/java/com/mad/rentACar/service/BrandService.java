package com.mad.rentACar.service;

import com.mad.rentACar.model.dtos.requests.CreateBrandRequest;
import com.mad.rentACar.model.dtos.requests.UpdateBrandRequest;
import com.mad.rentACar.model.dtos.responses.GetAllBrandsResponse;
import com.mad.rentACar.model.dtos.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
