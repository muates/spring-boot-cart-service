package com.bilgeadamboost.springbootcartservice.service.impl;

import com.bilgeadamboost.springbootcartservice.model.dto.request.CartCreateRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.CartResponse;
import com.bilgeadamboost.springbootcartservice.model.entity.CartEntity;
import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;
import com.bilgeadamboost.springbootcartservice.repository.CartRepository;
import com.bilgeadamboost.springbootcartservice.service.CartService;
import com.bilgeadamboost.springbootcartservice.service.MemberService;
import com.bilgeadamboost.springbootcartservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MemberService memberService;
    private final ProductService productService;

    @Override
    public void createCart(CartCreateRequest request) {
        MemberEntity existMember = memberService.getMember(request.getMemberId());

        CartEntity cart = new CartEntity();

        cart.setMember(existMember);

        cartRepository.save(cart);
    }

    @Override
    public CartResponse addProduct(Long productId) {
        return null;
    }
}
