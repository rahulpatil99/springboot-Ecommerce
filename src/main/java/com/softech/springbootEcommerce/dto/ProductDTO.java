package com.softech.springbootEcommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
    private long productId;
    private String productName;
    private String imgUrl;
    private double price;
    private String description;
    private double discount;
    private boolean inStock;
    @JsonProperty("isProductLike")
    private boolean isProductLike;

    public ProductDTO(long productId, String productName, String imgUrl, double price, String description, double discount, boolean inStock, boolean isProductLike) {
        this.productId = productId;
        this.productName = productName;
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.inStock = inStock;
        this.isProductLike = isProductLike;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isProductLike() {
        return isProductLike;
    }

    public void setProductLike(boolean isProductLike) {
        isProductLike = isProductLike;
    }
}
