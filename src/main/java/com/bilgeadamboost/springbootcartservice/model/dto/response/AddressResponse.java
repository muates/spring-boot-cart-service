package com.bilgeadamboost.springbootcartservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {

    private String addressName;
    private String country;
    private String city;
    private String neighbourhood;
    private String street;
    private String postalCode;
    private String address;
    private MemberResponse member;
}
