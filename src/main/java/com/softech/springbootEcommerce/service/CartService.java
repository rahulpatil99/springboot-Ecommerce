package com.softech.springbootEcommerce.service;

import com.softech.springbootEcommerce.dto.UserCartProductsDTO;
import com.softech.springbootEcommerce.model.Cart;
import com.softech.springbootEcommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<UserCartProductsDTO> getCartData(long userId){
        List<UserCartProductsDTO> userCart = cartRepository.findUserCartProductsByUserId(userId);
        return userCart;
    }

    public boolean insertProduct(Cart cart){
        List<Cart> cartItem = cartRepository.findByUserIdAndProductId(cart.getUserId(),cart.getProductId());
        Cart item = null;
        if(cartItem.isEmpty()) {
            item = cartRepository.save(cart);
        }
        else{
            int quantity = cartItem.get(0).getQuantity();
            cartItem.get(0).setQuantity(quantity+1);
            item = cartRepository.save(cartItem.get(0));
        }
        if(item!=null){
            return true;
        }
        return false;
    }

    public boolean deleteCartProduct(long userId,long productId){
        List<Cart> cart = cartRepository.findByUserIdAndProductId(userId,productId);
        if(cart.isEmpty()){
            return false;
        }
        else {
            cartRepository.delete(cart.get(0));
            return true;
        }
    }

    public int getCartCount(long userId){
        List<Cart> carts = cartRepository.findByUserId(userId);
        return carts.size();
    }

    public boolean updateQuantity(Cart cart){
        List<Cart> cartItem = cartRepository.findByUserIdAndProductId(cart.getUserId(),cart.getProductId());
        if(cartItem.isEmpty()){
            return false;
        }
        else{
            cartItem.get(0).setQuantity(cart.getQuantity());
            Cart upadatedCart = cartRepository.save(cartItem.get(0));
            if(upadatedCart!=null){
                return true;
            }
        }
        return false;

    }
}
