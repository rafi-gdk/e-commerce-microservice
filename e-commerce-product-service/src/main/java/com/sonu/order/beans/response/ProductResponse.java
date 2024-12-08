package com.sonu.order.beans.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse implements Serializable {

    private Integer productId;
    private String productName;
    private Double productFare;
}
