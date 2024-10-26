package com.softech.springbootEcommerce.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wishListId;

    private long userId;
    private long productId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false)
    @CreationTimestamp // Automatically sets the current date on insert
    private Date createdOn;
    private boolean isDeleted = false;

    public WishList() {
    }

    public WishList(long wishListId, long userId, long productId, Date createdOn, boolean isDeleted) {
        this.wishListId = wishListId;
        this.userId = userId;
        this.productId = productId;
        this.createdOn = createdOn;
        this.isDeleted = isDeleted;
    }

    public long getWishListId() {
        return wishListId;
    }

    public void setWishListId(long wishListId) {
        this.wishListId = wishListId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
