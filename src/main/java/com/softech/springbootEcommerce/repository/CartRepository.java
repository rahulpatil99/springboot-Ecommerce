package com.softech.springbootEcommerce.repository;

import com.softech.springbootEcommerce.dto.UserCartProductsDTO;
import com.softech.springbootEcommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

    @Query("SELECT new com.softech.springbootEcommerce.dto.UserCartProductsDTO(p.productId,c.userId, p.productName, p.imgUrl, p.price, p.description, p.discount, c.quantity) " +
            "FROM Cart c " +
            "INNER JOIN Product p ON c.productId = p.productId " +
            "WHERE c.userId = :userId")
    List<UserCartProductsDTO> findUserCartProductsByUserId(@Param("userId") long userId);

    List<Cart> findByUserIdAndProductId(long userId,long productId);

    List<Cart> findByUserId(long userId);

}
