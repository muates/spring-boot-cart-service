package com.bilgeadamboost.springbootcartservice.controller;

import com.bilgeadamboost.springbootcartservice.model.dto.request.CartCreateRequest;
import com.bilgeadamboost.springbootcartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/create")
    public void createCart(@RequestBody CartCreateRequest request) {
        cartService.createCart(request);
    }
}
