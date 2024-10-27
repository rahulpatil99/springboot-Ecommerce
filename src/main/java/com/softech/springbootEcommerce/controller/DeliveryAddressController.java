package com.softech.springbootEcommerce.controller;

import com.softech.springbootEcommerce.dto.DeliveryAddressDTO;
import com.softech.springbootEcommerce.dto.UserAndDeliveryAddressDTO;
import com.softech.springbootEcommerce.model.DeliveryAddress;
import com.softech.springbootEcommerce.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveryaddress")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @GetMapping("/{id}")
    public ResponseEntity<List<DeliveryAddress>> getAllCustomerAddress(@PathVariable long id){

        System.out.println(id);
        List<DeliveryAddress> deliveryAddressDTOList = deliveryAddressService.getAllDeliveryAddress(id);
        return ResponseEntity.ok(deliveryAddressDTOList);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress){
        boolean isUpdated = deliveryAddressService.updateDeliveryAddress(deliveryAddress);
        if(isUpdated)
            return ResponseEntity.ok("Delivery Address is updated");
        else
            return ResponseEntity.status(404).body("Delivery Address not updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress){
        boolean isDeleted = deliveryAddressService.deleteDeliveryAddress(deliveryAddress.getDeliveryAddressId());
        if(!isDeleted){
            return ResponseEntity.status(404).body("Delivery address not deleted");
        }
        return ResponseEntity.ok("Delivery address update successfully");
    }
}
