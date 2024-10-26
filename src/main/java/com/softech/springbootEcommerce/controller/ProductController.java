package com.softech.springbootEcommerce.controller;

import com.softech.springbootEcommerce.dto.ProductDTO;
import com.softech.springbootEcommerce.model.Product;
import com.softech.springbootEcommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<ProductDTO>> getAllProducts(@PathVariable long id){

        List<ProductDTO> productList = productService.getAllProducts(id);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id){
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

}
