package com.healthmgmt.app.service.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthmgmt.app.entity.v1.Productv1;
import com.healthmgmt.app.dao.v1.ProductRepositoryv1;

@Service
public class ProductServicev1 {
	@Autowired
	ProductRepositoryv1 productRepo;
	
	public List<Productv1> listAll() {
        //return productRepo.findAll();
		return productRepo.findByIsActiveTrue();
    }
     
    public long  save(Productv1 product) {
    	Productv1 product1=productRepo.save(product);
    		if(null!=product1) {
    			return product1.getItemId();
    		}
    		else {
    			return 0;
    		}
    	 
    }
     
    public Productv1 get(long id) {
        return productRepo.findById(id).get();
    }
    
       
    public boolean delete(long id) {
    	if(productRepo.existsById(id)) {
    		productRepo.deleteById(id);
    		return true;
    	}else {
    		return false;
    	}
    	
    }
	
}
