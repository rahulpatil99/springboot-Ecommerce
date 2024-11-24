package com.softech.springbootEcommerce.dto;

import com.softech.springbootEcommerce.model.ProductReview;

import java.util.Date;
import java.util.List;

public class ProductDetailsResponseDTO {
    private long productId;
    private String productName;

    private String brandName;
    private String imgUrl;
    private double price;
    private String description;
    private double discount;
    private boolean inStock;
    private String display;
    private String ramSize;
    private String storage;
    private String battery;
    private String processor;
    private String rearCamera;
    private String frontCamera;
    private Date releaseDate;
    private String colorOptions;
    private String warranty;
    private String weight;
    private String dimension;

    private List<ProductReviewDTO> productReviewDTOList;


    public ProductDetailsResponseDTO() {
    }

    public ProductDetailsResponseDTO(long productId, String productName, String brandName, String imgUrl, double price, String description, double discount, boolean inStock, String display, String ramSize, String storage, String battery, String processor, String rearCamera, String frontCamera, Date releaseDate, String colorOptions, String warranty, String weight, String dimension,List<ProductReviewDTO> productReviewDTOList) {
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.inStock = inStock;
        this.display = display;
        this.ramSize = ramSize;
        this.storage = storage;
        this.battery = battery;
        this.processor = processor;
        this.rearCamera = rearCamera;
        this.frontCamera = frontCamera;
        this.releaseDate = releaseDate;
        this.colorOptions = colorOptions;
        this.warranty = warranty;
        this.weight = weight;
        this.dimension = dimension;
        this.productReviewDTOList = productReviewDTOList;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getColorOptions() {
        return colorOptions;
    }

    public void setColorOptions(String colorOptions) {
        this.colorOptions = colorOptions;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<ProductReviewDTO> getProductReviewList() {
        return productReviewDTOList;
    }

    public void setProductReviewList(List<ProductReviewDTO> productReviewDTOList) {
        this.productReviewDTOList = productReviewDTOList;
    }
}
