package com.softech.springbootEcommerce.service;

import com.softech.springbootEcommerce.model.WishList;
import com.softech.springbootEcommerce.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    public boolean updateWishList(long userId,long productId){
        List<WishList> wishListItem = wishListRepository.findByUserIdAndProductId(userId,productId);
        if(wishListItem.isEmpty()){
            WishList wishList = new WishList();
            wishList.setProductId(productId);
            wishList.setUserId(userId);
            wishList = wishListRepository.save(wishList);
            if(wishList != null)
                    return true;
            return false;
        }else {
            wishListRepository.delete(wishListItem.get(0));
            return true;
        }

    }
}
