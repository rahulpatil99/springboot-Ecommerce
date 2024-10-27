package com.softech.springbootEcommerce.dto;

public class UserAndDeliveryAddressDTO {
    private long customerId;
    private long deliveryAddressId;

    public UserAndDeliveryAddressDTO() {
    }

    public UserAndDeliveryAddressDTO(long customerId, long deliveryAddressId) {
        this.customerId = customerId;
        this.deliveryAddressId = deliveryAddressId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }
}
