package com.softech.springbootEcommerce.repository;

import com.softech.springbootEcommerce.dto.ProductReviewDTO;
import com.softech.springbootEcommerce.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductReviewRepository extends JpaRepository<ProductReview,Long> {

    @Query("SELECT new com.softech.springbootEcommerce.dto.ProductReviewDTO(CONCAT(u.firstName,' ',u.lastName),pr.review,pr.rate,pr.reviewDate) " +
            "FROM ProductReview pr " +
            "INNER JOIN User u " +
            "ON pr.userId = u.userId " +
            "WHERE pr.productId = :productId " +
            "AND pr.isDeleted = false AND u.isDeleted = false"
    )
    public List<ProductReviewDTO> findAllByProductId(@Param("productId") long productId);
}
