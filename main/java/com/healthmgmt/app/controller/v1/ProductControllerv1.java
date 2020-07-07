package com.healthmgmt.app.controller.v1;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.healthmgmt.app.service.v1.ProductServicev1;
import com.healthmgmt.app.entity.v1.Productv1;

@RestController
@RequestMapping("/healthmgmt")
public class ProductControllerv1 {
	@Autowired
	ProductServicev1 productService;
	
	@PostMapping("/product")
	public long  save(Productv1 product){
		return productService.save(product);
	}
	
	@GetMapping("/product/{itemId}")
	public Productv1 getProductById(@PathVariable long itemId) {
		return productService.get(itemId);
	}
	
	@GetMapping("/product/list")
	public List<Productv1> listAllProduct(){
		List<Productv1> productList=new ArrayList<Productv1>();
		System.out.println("in the listAllproduct==================");
		productList=productService.listAll();
		return productList;
	}
	
//	@RequestMapping("/productmaster/listall")
//	public String listAllProductMaster(Model model){
//		List<Productv1> productList=new ArrayList<Productv1>();
//		System.out.println("in the listAllProductMaster.listAllproduct==================");
//		productList=productService.listAll();
//		
//		model.addAttribute("listProducts", productList);
//		
//		return "listProductMaster";
//	}
//	
	@GetMapping("/product/delete/{itemId}")
	public boolean delete(long id) {
		long productId=0;
		Productv1 product= productService.get(id);
		product.setActive(false);
		productId=productService.save(product);
		if(productId!=0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	

}
