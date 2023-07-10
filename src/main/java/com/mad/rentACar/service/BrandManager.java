package com.mad.rentACar.service;

import com.mad.rentACar.core.utilities.mappers.ModelMapperService;
import com.mad.rentACar.model.dtos.requests.UpdateBrandRequest;
import com.mad.rentACar.model.dtos.responses.GetByIdBrandResponse;
import com.mad.rentACar.model.entities.Brand;
import com.mad.rentACar.repository.BrandRepository;
import com.mad.rentACar.model.dtos.requests.CreateBrandRequest;
import com.mad.rentACar.model.dtos.responses.GetAllBrandsResponse;
import com.mad.rentACar.service.rules.BrandBusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService, BrandBusinessRules brandBusinessRules) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.brandBusinessRules = brandBusinessRules;
    }

    @Override
    public List<GetAllBrandsResponse > getAll() {
        
        
        List<Brand> brands = brandRepository.findAll();
        
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());
        
        
        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
