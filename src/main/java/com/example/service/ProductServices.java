package com.example.service;

import com.example.models.Product;
import com.example.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServices {
    private final ProductRepository productRepository;

    public ProductServices() {
        productRepository = new ProductRepository();
    }

    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllPro() {
        return productRepository.getAllPro();
    }
    public boolean insertPro(Product product){
        productRepository.insertPro(product);
        return true;
    }
    public boolean updatePro(Product product){
        productRepository.updatePro(product);
        return true;
    }
    public boolean deletePro(long id){
        productRepository.deletePro(id);
        return true;
    }
    public boolean activePro(long id){
        productRepository.activePro(id);
        return true;
    }
}
