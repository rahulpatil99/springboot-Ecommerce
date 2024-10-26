package com.softech.springbootEcommerce.service;

import com.softech.springbootEcommerce.dto.ProductDTO;
import com.softech.springbootEcommerce.model.Product;
import com.softech.springbootEcommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(long userId){
        return productRepository.findAllProduct(userId);
    }

    public Product getProduct(long productId){
        return productRepository.findById(productId).get();
    }
}
