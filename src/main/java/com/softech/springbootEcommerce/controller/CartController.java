package com.softech.springbootEcommerce.controller;

import com.softech.springbootEcommerce.dto.UserCartProductsDTO;
import com.softech.springbootEcommerce.model.Cart;
import com.softech.springbootEcommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/userproducts/{id}")
    public ResponseEntity<List<UserCartProductsDTO>> getAllUserCartProducts(@PathVariable("id") long userId){
        List<UserCartProductsDTO> userCartProductsDTOS = cartService.getCartData(userId);
        return ResponseEntity.ok(userCartProductsDTOS);
    }

    @PostMapping("/addproduct")
    public ResponseEntity<String> insertProductInCart(@RequestBody Cart cart){
        System.out.println(cart.getUserId()+" "+cart.getProductId());
        boolean isSaved = cartService.insertProduct(cart);
        if(isSaved){
            return ResponseEntity.ok("Product Inserted successfully.");
        }
        else{
            return ResponseEntity.status(404).body("Product not inserted.");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody Cart cart){
        System.out.println(cart.getUserId()+" "+cart.getProductId());
        boolean isDeleted = cartService.deleteCartProduct(cart.getUserId(),cart.getProductId());
        if (isDeleted) {
            return ResponseEntity.ok("Product deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Product not found.");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCartCount(@RequestParam long userId){
        Integer count = cartService.getCartCount(userId);
        return ResponseEntity.ok(count);
    }

    @PutMapping("/update/quantity")
    public ResponseEntity<String> updateQuantity(@RequestBody Cart cart){
        boolean isUpdated = cartService.updateQuantity(cart);
        if(isUpdated){
            return ResponseEntity.ok("Cart updated successfully");
        }
        else{
            return ResponseEntity.status(404).body("Product not found.");
        }

    }


}
