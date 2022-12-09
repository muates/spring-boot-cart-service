package com.bilgeadamboost.springbootcartservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAddRequest {

    private String productName;
    private Float price;
    private Integer quantity;
}
