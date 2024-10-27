package com.softech.springbootEcommerce.repository;

import com.softech.springbootEcommerce.dto.ProductDTO;
import com.softech.springbootEcommerce.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Long> {

    @Query("SELECT new com.softech.springbootEcommerce.dto.ProductDTO(" +
            "p.productId," +
            "p.productName," +
            "p.imgUrl," +
            "p.price," +
            "p.description," +
            "p.discount," +
            "p.inStock," +
            "TRUE AS isProductLike) "+
            "FROM Product p " +
            "INNER JOIN WishList wl " +
            "ON p.productId = wl.productId " +
            "WHERE wl.userId = :userId")
    public List<ProductDTO> findProductByCustomerId(@Param("userId") long userId);
    public List<WishList> findByUserIdAndProductId(long userId,long productId);
}
