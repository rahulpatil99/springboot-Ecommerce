package com.softech.springbootEcommerce.repository;

import com.softech.springbootEcommerce.model.ProductParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductParameterRepository extends JpaRepository<ProductParameters,Long> {
    public ProductParameters findByProductId(long productId);
}
