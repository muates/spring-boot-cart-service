package com.bilgeadamboost.springbootcartservice.model.dto.request;

import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressAddRequest {

    @NotBlank
    private String addressName;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String neighbourhood;

    @NotBlank
    private String street;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String address;

    @NotNull
    private MemberEntity member;

}
