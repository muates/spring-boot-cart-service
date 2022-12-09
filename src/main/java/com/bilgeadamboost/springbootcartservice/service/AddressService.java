package com.bilgeadamboost.springbootcartservice.service;

import com.bilgeadamboost.springbootcartservice.model.dto.request.AddressAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.AddressUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.entity.AddressEntity;

import java.util.List;

public interface AddressService {
    AddressEntity addAddress(AddressAddRequest request);
    AddressEntity getAddress(Long id);
    AddressEntity updateAddress(Long id, AddressUpdateRequest request);
    void deleteAddress(Long id);
    List<AddressEntity> getAllAddressByMemberId(Long id);
    int findAddressLengthByMemberId(Long id);
}
