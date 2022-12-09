package com.bilgeadamboost.springbootcartservice.controller;

import com.bilgeadamboost.springbootcartservice.converter.ProductConverter;
import com.bilgeadamboost.springbootcartservice.model.dto.request.ProductAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.ProductUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.ProductResponse;
import com.bilgeadamboost.springbootcartservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadamboost.springbootcartservice.controller.endpoint.ProductControllerEndpoint.*;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping(ADD_PRODUCT)
    public ProductResponse addProduct(@RequestBody @Valid ProductAddRequest request) {
        return ProductConverter.convertToResponse(productService.addProduct(request));
    }

    @GetMapping(GET_PRODUCT)
    public ProductResponse getProduct(@PathVariable Long id) {
        return ProductConverter.convertToResponse(productService.getProduct(id));
    }

    @DeleteMapping(DELETE_PRODUCT)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping(UPDATE_PRODUCT)
    public ProductResponse updateProduct(@PathVariable Long id,
                                         @RequestBody @Valid ProductUpdateRequest request) {
        return ProductConverter.convertToResponse(productService.updateProduct(id, request));
    }

    @GetMapping(GET_PRODUCTS)
    public List<ProductResponse> getProducts() {
        return ProductConverter.convertToResponse(productService.getProducts());
    }
}
