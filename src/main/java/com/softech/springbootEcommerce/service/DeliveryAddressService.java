package com.softech.springbootEcommerce.service;

import com.softech.springbootEcommerce.dto.DeliveryAddressDTO;
import com.softech.springbootEcommerce.dto.UserAndDeliveryAddressDTO;
import com.softech.springbootEcommerce.model.DeliveryAddress;
import com.softech.springbootEcommerce.repository.DeliveryAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {
    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    public List<DeliveryAddress> getAllDeliveryAddress(long customerId){
        List<DeliveryAddress> deliveryAddressDTOList = deliveryAddressRepository.findByCustomerId(customerId);
        return deliveryAddressDTOList;
    }

    public boolean updateDeliveryAddress(DeliveryAddress deliveryAddressDTO){
        DeliveryAddress updatedDeliveryAddress = deliveryAddressRepository.save(deliveryAddressDTO);
        if(updatedDeliveryAddress==null){
            return false;
        }
        return true;
    }

    public boolean deleteDeliveryAddress(long deliveryAddressId){
        DeliveryAddress deliveryAddress = deliveryAddressRepository.getReferenceById(deliveryAddressId);
        if(deliveryAddress != null) {
            deliveryAddressRepository.deleteById(deliveryAddressId);
            return true;
        }
        return false;
    }
}
