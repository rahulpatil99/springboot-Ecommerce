package com.softech.springbootEcommerce.dto;

public class UserCartProductsDTO {
    private long productId;
    private long userId;
    private String productName;
    private String imgUrl;
    private double price;
    private String description;
    private double discount;
    private int quantity;

    public UserCartProductsDTO(long productId, long userId, String productName, String imgUrl, double price, String description, double discount, int quantity) {
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.quantity = quantity;
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
