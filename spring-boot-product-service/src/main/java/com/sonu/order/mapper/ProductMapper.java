package com.sonu.order.mapper;

import com.sonu.order.beans.entity.Product;
import com.sonu.order.beans.request.ProductRequest;
import com.sonu.order.beans.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product prepareRequest(ProductRequest productRequest);

    ProductResponse prepareResponse(Product product);

    List<ProductResponse> prepareResponse(List<Product> products);
}
