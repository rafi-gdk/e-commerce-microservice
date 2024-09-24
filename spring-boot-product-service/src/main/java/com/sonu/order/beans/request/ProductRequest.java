package com.sonu.order.beans.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @Id
    private Integer productId;
    private String productName;
    private Double productFare;
}
