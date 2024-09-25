package com.sonu.order.mapper;

import com.sonu.order.beans.entity.Product;
import com.sonu.order.beans.request.ProductRequest;
import com.sonu.order.beans.response.ProductResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T17:15:03+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.1.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product prepareRequest(ProductRequest productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productRequest.getProductId() );
        product.setProductName( productRequest.getProductName() );
        product.setProductFare( productRequest.getProductFare() );

        return product;
    }

    @Override
    public ProductResponse prepareResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductId( product.getProductId() );
        productResponse.setProductName( product.getProductName() );
        productResponse.setProductFare( product.getProductFare() );

        return productResponse;
    }

    @Override
    public List<ProductResponse> prepareResponse(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( products.size() );
        for ( Product product : products ) {
            list.add( prepareResponse( product ) );
        }

        return list;
    }
}
