package com.sonu.order.service;

import com.sonu.order.beans.request.ProductRequest;
import com.sonu.order.beans.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductResponse getProduct(Integer id);

    ProductResponse addProduct(ProductRequest productRequest);

    String deleteProduct(Integer productId);

    List<ProductResponse> getAllProducts();

}
