package com.bilgeadamboost.springbootcartservice.converter;

import com.bilgeadamboost.springbootcartservice.model.dto.request.ProductAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.ProductResponse;
import com.bilgeadamboost.springbootcartservice.model.entity.ProductEntity;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public static ProductEntity convertToProduct(ProductAddRequest request) {
        if (request == null)
            return null;

        return ProductEntity.builder()
                .productName(request.getProductName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .createdDate(new Date())
                .build();
    }

    public static ProductResponse convertToResponse(ProductEntity product) {
        if (product == null)
            return null;

        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public static List<ProductResponse> convertToResponse(List<ProductEntity> product) {
        if (product.isEmpty())
            return Collections.emptyList();

        return product.stream()
                .map(ProductConverter::convertToResponse)
                .collect(Collectors.toList());
    }
}
