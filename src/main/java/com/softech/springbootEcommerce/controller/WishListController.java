package com.softech.springbootEcommerce.controller;

import com.softech.springbootEcommerce.dto.ProductDTO;
import com.softech.springbootEcommerce.dto.UserProductDTO;
import com.softech.springbootEcommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    private WishListService wishListService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDTO>>  getAllWishListProduct(@PathVariable long id){
        List<ProductDTO> products = wishListService.getAllWishListProduct(id);

        return ResponseEntity.ok(products);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateWishList(@RequestBody UserProductDTO userProductDTO){
        boolean response = wishListService.updateWishList(userProductDTO.getUserId(),userProductDTO.getProductId());
        if(response)
            return ResponseEntity.ok("WishList updated successfully");
        else
            return ResponseEntity.status(404).body("WishList not updated");
    }
}
