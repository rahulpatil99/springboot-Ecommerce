package com.softech.springbootEcommerce.service;

import com.softech.springbootEcommerce.dto.ProductDTO;
import com.softech.springbootEcommerce.dto.ProductReviewDTO;
import com.softech.springbootEcommerce.model.Product;
import com.softech.springbootEcommerce.model.ProductParameters;
import com.softech.springbootEcommerce.dto.ProductDetailsResponseDTO;
import com.softech.springbootEcommerce.model.ProductReview;
import com.softech.springbootEcommerce.repository.ProductParameterRepository;
import com.softech.springbootEcommerce.repository.ProductRepository;
import com.softech.springbootEcommerce.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductParameterRepository productParameterRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductDTO> getAllProducts(long userId){
        return productRepository.findAllProduct(userId);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(long productId){
        return productRepository.findById(productId).get();
    }

    public boolean addProduct(Product productData, ProductParameters productParametersData){
        Product p = productRepository.save(productData);
        productParametersData.setProductId(p.getProductId());
        ProductParameters parameters = productParameterRepository.save(productParametersData);
        if(parameters!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public ProductDetailsResponseDTO getProductDetails(long productId){
        Optional<Product> productOPT = productRepository.findById(productId);
        if(productOPT.isEmpty()) return null;

        Product product = productOPT.get();
        List<ProductReviewDTO> productReviewDTOList = productReviewRepository.findAllByProductId(productId);
//        System.out.println(productReviewDTOList);
//        List<ProductReview> productReviewList = productReview
//                .map(Collections::singletonList) // Wraps the found item in a singleton list
//                .orElse(Collections.emptyList());
        ProductParameters productParameter = productParameterRepository.findByProductId(productId);
        if(productParameter==null) return null;
        return new ProductDetailsResponseDTO(
                product.getProductId(),
                product.getProductName(),
                product.getBrandName(),
                product.getImgUrl(),
                product.getPrice(),
                product.getDescription(),
                product.getDiscount(),
                product.isInStock(),
                productParameter.getDisplay(),
                productParameter.getRamSize(),
                productParameter.getStorage(),
                productParameter.getBattery(),
                productParameter.getProcessor(),
                productParameter.getRearCamera(),
                productParameter.getFrontCamera(),
                productParameter.getReleaseDate(),
                productParameter.getColorOptions(),
                productParameter.getWarranty(),
                productParameter.getWeight(),
                productParameter.getDimension(),
                productReviewDTOList
        );

    }
}
