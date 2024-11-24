package com.softech.springbootEcommerce.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class ProductParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long productParametersId;
    long productId;
    String display;
    String ramSize;
    String storage;
    String battery;
    String Processor;
    String rearCamera;
    String frontCamera;
    Date releaseDate;
    String colorOptions;
    String warranty;
    String weight;
    String dimension;
    boolean isDeleted;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false)
    @CreationTimestamp // Automatically sets the current date on insert
    private Date createdOn;

    public long getProductParametersId() {
        return productParametersId;
    }

    public void setProductParametersId(long productParametersId) {
        this.productParametersId = productParametersId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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
        return Processor;
    }

    public void setProcessor(String processor) {
        Processor = processor;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
