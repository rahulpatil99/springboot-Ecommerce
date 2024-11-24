package com.softech.springbootEcommerce.controller;

import com.softech.springbootEcommerce.dto.ProductOrderHistoryResponseDTO;
import com.softech.springbootEcommerce.dto.ProductOrderRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/order")
public class ProductOrderController {

    @PostMapping("/get")
    public ResponseEntity<List<ProductOrderHistoryResponseDTO>> getAllOrderHistory(@RequestBody long customerId){

        return ResponseEntity.ok(new ArrayList<ProductOrderHistoryResponseDTO>());
    }

    @PostMapping("/update")
    public ResponseEntity<String> insertOrder(@RequestBody ProductOrderRequestDTO productOrderRequestDTO){

        return ResponseEntity.ok("");
    }
}
