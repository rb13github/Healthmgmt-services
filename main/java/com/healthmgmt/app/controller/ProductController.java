package com.healthmgmt.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.service.ProductService;

@Controller
@RequestMapping("/healthmgmt/Products")
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    // handler methods...
    
    @GetMapping
	public String webget (){
		return " entered in the product controller /healthmgt/Products";
	
	}
    @RequestMapping("/getProducts")
    public String viewProductsPage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        System.out.println("listproducts    :   "+listProducts);
         
        return "fetchProducts";
    }
    
    @RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
    
    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
         
        return "new_product";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
         
        return "redirect:/healthmgmt/Products/getProducts";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("edit_product");
        System.out.println("showEditProductPage: editing the product with id : "+id);
        Product product = service.get(Integer.parseInt(id));
        mav.addObject("product", product);
         
        System.out.println("showEditProductPage: In  the product with id : "+product.getId());
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/healthmgmt/Products/getProducts";       
    }
}
