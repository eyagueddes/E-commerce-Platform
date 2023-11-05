package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.Product;
import com.example.ecommerce_platform.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {



    @Autowired
    private ProductService productService;

    @PostMapping("/add")

   public Product addProduct(@Valid @RequestBody Product product){
        System.out.println("begin");
        Product p= productService.addProduct(product);
        System.out.println(p);
        return  p;
   }
    @GetMapping("list")
    public List<Product> getProducts(){
        return  productService.getAllProducts();
    }
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId ){
        return productService.getOneProduct(productId);
    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable Long productId ){
        return productService.deleteProduct(productId);
    }
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId,@RequestBody Product product ){
        return productService.updateProduct(product,productId);
    }


}
