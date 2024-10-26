package com.softech.springbootEcommerce.dto;

public class UserProductDTO {
    private long userId;
    private long productId;

    public UserProductDTO(long userId, long productId) {
        this.userId = userId;
        this.productId = productId;
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
}
