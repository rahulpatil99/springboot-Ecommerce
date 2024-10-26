package com.softech.springbootEcommerce.repository;

import com.softech.springbootEcommerce.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Long> {

    public List<WishList> findByUserIdAndProductId(long userId,long productId);
}
