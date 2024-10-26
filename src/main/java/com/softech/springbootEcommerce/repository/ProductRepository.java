package com.softech.springbootEcommerce.repository;


import com.softech.springbootEcommerce.dto.ProductDTO;
import com.softech.springbootEcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query( "SELECT " +
            "new com.softech.springbootEcommerce.dto.ProductDTO(" +
            "p.productId," +
            "p.productName," +
            "p.imgUrl," +
            "p.price," +
            "p.description," +
            "p.discount," +
            "p.inStock," +
            "CASE WHEN wl.userId IS NULL THEN FALSE ELSE TRUE END AS isProductLike) " +
            "FROM Product p " +
            "LEFT JOIN WishList wl " +
            "ON p.productId = wl.productId " +
            "AND wl.userId = :userId "
    )
    public List<ProductDTO> findAllProduct(@Param("userId") long userId);
}
