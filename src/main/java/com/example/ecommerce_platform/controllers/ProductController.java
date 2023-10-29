package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.Product;
import com.example.ecommerce_platform.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {



    @Autowired
    private ProductService productService;

    @PostMapping("add")
   public Product addProduct(@Valid @RequestBody Product product){
       return  productService.addProduct(product);
   }
    @GetMapping("list")
    public List<Product> getProducts(){
        return  productService.getAllProducts();
    }
    @GetMapping("/{providerId}")
    public Product getProduct(@PathVariable int providerId ){
        return productService.getOneProduct(providerId);
    }

    @DeleteMapping("/{providerId}")
    public Product deleteProduct(@PathVariable int providerId ){
        return productService.deleteProduct(providerId);
    }
    @PutMapping("/{providerId}")
    public Product updateProduct(@PathVariable int providerId,@RequestBody Product product ){
        return productService.updateProduct(product,providerId);
    }


}
