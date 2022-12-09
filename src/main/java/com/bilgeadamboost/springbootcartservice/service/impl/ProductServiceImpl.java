package com.bilgeadamboost.springbootcartservice.service.impl;

import com.bilgeadamboost.springbootcartservice.converter.ProductConverter;
import com.bilgeadamboost.springbootcartservice.exception.GlobalException;
import com.bilgeadamboost.springbootcartservice.model.dto.request.ProductAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.ProductUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.entity.ProductEntity;
import com.bilgeadamboost.springbootcartservice.repository.ProductRepository;
import com.bilgeadamboost.springbootcartservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity addProduct(ProductAddRequest request) {
        return productRepository.save(ProductConverter.convertToProduct(request));
    }

    @Override
    public ProductEntity getProduct(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isEmpty())
            throw new GlobalException("Ürün bulunamadı!!!", HttpStatus.NOT_FOUND);

        return product.get();
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductUpdateRequest request) {
        ProductEntity product = getProduct(id);

        if (request.getProductName() != null) product.setProductName(request.getProductName());
        if (request.getPrice() != null) product.setPrice(request.getPrice());
        if (request.getQuantity() != null) product.setQuantity(request.getQuantity());

        product.setUpdatedDate(new Date());

        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }
}
