package com.softech.springbootEcommerce.controller;

import com.softech.springbootEcommerce.dto.UserProductDTO;
import com.softech.springbootEcommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    private WishListService wishListService;

    @PutMapping("/update")
    public ResponseEntity<String> updateWishList(@RequestBody UserProductDTO userProductDTO){
        boolean response = wishListService.updateWishList(userProductDTO.getUserId(),userProductDTO.getProductId());
        if(response)
            return ResponseEntity.ok("WishList updated successfully");
        else
            return ResponseEntity.status(404).body("WishList not updated");
    }
}
