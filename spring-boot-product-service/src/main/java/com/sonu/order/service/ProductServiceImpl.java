package com.sonu.order.service;

import com.sonu.order.beans.entity.Product;
import com.sonu.order.beans.request.ProductRequest;
import com.sonu.order.beans.response.ProductResponse;
import com.sonu.order.exception.ProductDataException;
import com.sonu.order.mapper.ProductMapper;
import com.sonu.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public ProductResponse getProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productMapper.prepareResponse(product.get());
        }
        throw new ProductDataException("Product Not Found");
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.prepareResponse(productRepository.findAll());
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = null;
        Optional<Product> productById = productRepository.findById(productRequest.getProductId());
        if (productById.isPresent()) {
            throw new ProductDataException("Product already Exist");
        } else {
            product = productRepository.save(productMapper.prepareRequest(productRequest));
            if (product == null) {
                throw new ProductDataException("Product Insert Failed");
            }
        }
        return productMapper.prepareResponse(product);
    }

    @Override
    public String deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        return "Success";
    }
}
