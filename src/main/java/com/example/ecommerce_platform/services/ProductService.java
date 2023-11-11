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


    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product addProduct( Product product) {
        return productRepository.save(product);
    }

    public Product getOneProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("product id " + productId + " not found"));
    }

    public Product updateProduct( Product product, Long productId) {

        Optional<Product> productToUpdate = productRepository.findById(productId);
        if (productToUpdate.isPresent()) {
//            p = p.get();//take the previous object
            productToUpdate.get().setDescription(product.getDescription());
            productToUpdate.get().setName(product.getName());
            productToUpdate.get().setPrice(product.getPrice());
            productToUpdate.get().setStock(product.getStock());
            productRepository.save(productToUpdate.get());

        }
        if (productToUpdate == null) {
            throw new IllegalArgumentException("Provider not found");
        }
        return productToUpdate.get();

    }

    public Product deleteProduct(Long productId) {
        Optional<Product> p = productRepository.findById(productId);
        if (p.isPresent()) {
            productRepository.delete(p.get());
        }
        if (p.get() == null) {
            throw new IllegalArgumentException("Product not found");
        }
        return p.get();
    }
}
