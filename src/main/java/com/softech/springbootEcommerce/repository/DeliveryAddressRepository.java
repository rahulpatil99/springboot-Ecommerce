package com.softech.springbootEcommerce.repository;

import com.softech.springbootEcommerce.model.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress,Integer> {
}
