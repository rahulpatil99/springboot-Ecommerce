package com.softech.springbootEcommerce.dto;

public class DeliveryAddressDTO {
    private long deliveryAddressId;
    private long customerId;
    private String fullName;
    private String mobileNumber;
    private long pinCode;
    private String state;
    private String city;
    private String address;
    private String addressType;

    public DeliveryAddressDTO() {
    }

    public DeliveryAddressDTO(long deliveryAddressId, long customerId, String fullName, String mobileNumber, long pinCode, String state, String city, String address, String addressType) {
        this.deliveryAddressId = deliveryAddressId;
        this.customerId = customerId;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
        this.address = address;
        this.addressType = addressType;
    }

    public long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
