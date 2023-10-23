package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.Product;
import com.example.ecommerce_platform.repository.ProductRepository;
import com.example.ecommerce_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }
    public Product addProduct(@Valid @RequestBody Product product){
      return  productRepository.save(product);
    }
    public Product getOneProduct(@PathVariable int productId){
        return productRepository.findById(productId).orElseThrow(()->new IllegalArgumentException("product id "+productId+" not found"));
    }
    public Product updateProduct(@Valid @RequestBody Product product,@PathVariable int productId ){
        Product productToUpdate=null;
       Optional<Product> p= productRepository.findById(productId);
       if(p.isPresent()){
           productToUpdate=p.get();//take the previous object
           productToUpdate.setDescription(product.getDescription());
           productToUpdate.setName(product.getName());
           productToUpdate.setPrice(product.getPrice());
           productToUpdate.setStock(product.getStock());
           productRepository.save(productToUpdate);

       }
       if(productToUpdate==null){
           throw new IllegalArgumentException("Provider not found");
       }
       return productToUpdate;

    }

    public Product deleteProduct(@PathVariable int productId ){
        Optional<Product> p=productRepository.findById(productId);
        if(p.isPresent()){
            productRepository.delete(p.get());
        }
        if(p.get()==null){
            throw new IllegalArgumentException("Product not found");
        }
        return p.get();
    }
}
