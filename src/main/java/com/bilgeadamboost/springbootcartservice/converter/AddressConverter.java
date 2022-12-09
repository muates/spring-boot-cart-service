package com.bilgeadamboost.springbootcartservice.converter;

import com.bilgeadamboost.springbootcartservice.model.dto.request.AddressAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.AddressResponse;
import com.bilgeadamboost.springbootcartservice.model.entity.AddressEntity;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {

    public static AddressEntity convertToAddress(AddressAddRequest request) {
        if (request == null)
            return null;

        return AddressEntity.builder()
                .addressName(request.getAddressName())
                .country(request.getCountry())
                .city(request.getCity())
                .neighbourhood(request.getNeighbourhood())
                .street(request.getStreet())
                .postalCode(request.getPostalCode())
                .address(request.getAddress())
                .member(request.getMember())
                .createdDate(new Date())
                .build();
    }

    public static AddressResponse convertToResponse(AddressEntity address) {
        if (address == null)
            return null;

        return AddressResponse.builder()
                .addressName(address.getAddressName())
                .country(address.getCountry())
                .city(address.getCity())
                .neighbourhood(address.getNeighbourhood())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .address(address.getAddress())
                .member(MemberConverter.convertToResponse(address.getMember()))
                .build();
    }

    public static List<AddressResponse> convertToResponse(List<AddressEntity> addresses) {
        if (addresses.isEmpty())
            return Collections.emptyList();

        return addresses.stream()
                .map(AddressConverter::convertToResponse)
                .collect(Collectors.toList());
    }
}
