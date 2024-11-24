package com.softech.springbootEcommerce.dto;

import java.util.Date;

public class ProductOrderHistoryResponseDTO {
    private long OrderId;
    private String productTitle;
    private Date orderCondirmDate;
    private Date orderDeliveredDate;
    private String deliveryCustomerName;
    private String deliveryAddress;
    private String deliveryCustomerNumber;
    private double listPrice;
    private double sellingPrice;
    private double discount;
    private double deliveryCharges;
    private int productRating;
    private String productComment;
    private String paymentMethod;

    public ProductOrderHistoryResponseDTO() {
    }

//    public ProductOrderHistoryResponseDTO(long orderId, String productTitle, Date orderCondirmDate, Date orderDeliveredDate, String deliveryCustomerName, String deliveryAddress, String deliveryCustomerNumber, double listPrice, double sellingPrice, double discount, double deliveryCharges, int productRating, String productComment, String paymentMethod) {
//        OrderId = orderId;
//        this.productTitle = productTitle;
//        this.orderCondirmDate = orderCondirmDate;
//        this.orderDeliveredDate = orderDeliveredDate;
//        this.deliveryCustomerName = deliveryCustomerName;
//        this.deliveryAddress = deliveryAddress;
//        this.deliveryCustomerNumber = deliveryCustomerNumber;
//        this.listPrice = listPrice;
//        this.sellingPrice = sellingPrice;
//        this.discount = discount;
//        this.deliveryCharges = deliveryCharges;
//        this.productRating = productRating;
//        this.productComment = productComment;
//        this.paymentMethod = paymentMethod;
//    }

    public long getOrderId() {
        return OrderId;
    }

    public void setOrderId(long orderId) {
        OrderId = orderId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Date getOrderCondirmDate() {
        return orderCondirmDate;
    }

    public void setOrderCondirmDate(Date orderCondirmDate) {
        this.orderCondirmDate = orderCondirmDate;
    }

    public Date getOrderDeliveredDate() {
        return orderDeliveredDate;
    }

    public void setOrderDeliveredDate(Date orderDeliveredDate) {
        this.orderDeliveredDate = orderDeliveredDate;
    }

    public String getDeliveryCustomerName() {
        return deliveryCustomerName;
    }

    public void setDeliveryCustomerName(String deliveryCustomerName) {
        this.deliveryCustomerName = deliveryCustomerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryCustomerNumber() {
        return deliveryCustomerNumber;
    }

    public void setDeliveryCustomerNumber(String deliveryCustomerNumber) {
        this.deliveryCustomerNumber = deliveryCustomerNumber;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
