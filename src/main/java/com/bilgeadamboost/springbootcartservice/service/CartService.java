package com.bilgeadamboost.springbootcartservice.service;

import com.bilgeadamboost.springbootcartservice.model.dto.request.CartCreateRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.CartResponse;

public interface CartService {

    void createCart(CartCreateRequest request);

    CartResponse addProduct(Long productId);
}
