package com.sonu.order.controller;

import com.sonu.order.beans.request.ProductRequest;
import com.sonu.order.beans.response.ProductResponse;
import com.sonu.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/getProduct/{id}")
    public ProductResponse getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping(value = "/getAllProducts")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/addProduct")
    public ProductResponse addProduct(@RequestBody ProductRequest product) {
        return productService.addProduct(product);
    }

    @DeleteMapping(value = "/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}
