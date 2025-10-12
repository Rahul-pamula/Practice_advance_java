package com.parul.JPAExample1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.parul.JPAExample1.repository.ProductRepositoryImpl;
import com.parul.JPAExample1.models.Product;
 @Controller
public class productController {
    @Autowired
    ProductRepositoryImpl service;

    @GetMapping("/")
    public ModelAndView landing(ModelAndView model) {
        model.addObject("allproducts", service.listAll());
        model.setViewName("index");
        return model;
    }

    @GetMapping("/newProduct")
    public ModelAndView newProduct(ModelAndView model) {
        model.addObject("product", new Product());
        model.setViewName("newProduct");
        return model;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct( @ModelAttribute("product") Product product,
            ModelAndView model) {
        System. out .println(product.getId() + " " + product.getName());
        service.save(product);
        model.addObject("allproducts", service.listAll());
        model.setViewName("index");
        return model;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProduct( @PathVariable Long id, ModelAndView model) {
        model.addObject("product", service.get(id));
        model.setViewName("newProduct");
        return model;
    }

    @GetMapping("/delete/{id}")
    public String delProduct( @PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}