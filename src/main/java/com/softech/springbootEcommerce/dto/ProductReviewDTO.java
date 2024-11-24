package com.softech.springbootEcommerce.dto;

import java.util.Date;

public class ProductReviewDTO {
    private String userName;
    private String review;
    private int rate;
    private Date reviewDate;

    public ProductReviewDTO() {
    }

    public ProductReviewDTO(String userName, String review, int rate, Date reviewDate) {
        this.userName = userName;
        this.review = review;
        this.rate = rate;
        this.reviewDate = reviewDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
