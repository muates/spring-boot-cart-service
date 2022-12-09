package com.bilgeadamboost.springbootcartservice.service;

import com.bilgeadamboost.springbootcartservice.model.dto.request.ProductAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.ProductUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity addProduct(ProductAddRequest request);
    ProductEntity getProduct(Long id);
    ProductEntity updateProduct(Long id, ProductUpdateRequest request);
    void deleteProduct(Long id);
    List<ProductEntity> getProducts();
}
