package com.mad.rentACar.service.rules;

import com.mad.rentACar.core.utilities.exceptions.BusinessException;
import com.mad.rentACar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    
    private BrandRepository brandRepository;
    
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists");
        }
    }
}
