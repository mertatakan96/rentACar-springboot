package com.mad.rentACar.webApi.controllers;

import com.mad.rentACar.model.dtos.requests.UpdateBrandRequest;
import com.mad.rentACar.model.dtos.responses.GetByIdBrandResponse;
import com.mad.rentACar.service.BrandService;
import com.mad.rentACar.model.dtos.requests.CreateBrandRequest;
import com.mad.rentACar.model.dtos.responses.GetAllBrandsResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class  BrandsController {
    
    private BrandService brandService;
    
    @Autowired // IoC
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
    
    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }
    
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }
    
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
    
    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
