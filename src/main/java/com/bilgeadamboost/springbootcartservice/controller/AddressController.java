package com.bilgeadamboost.springbootcartservice.controller;

import com.bilgeadamboost.springbootcartservice.converter.AddressConverter;
import com.bilgeadamboost.springbootcartservice.model.dto.request.AddressAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.AddressUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.AddressResponse;
import com.bilgeadamboost.springbootcartservice.model.entity.AddressEntity;
import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;
import com.bilgeadamboost.springbootcartservice.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadamboost.springbootcartservice.controller.endpoint.AddressControllerEndpoint.*;

@RequiredArgsConstructor
@RestController
public class AddressController {

    private final AddressService addressService;

    @PostMapping(ADD_ADDRESS)
    public AddressResponse addAddress(@RequestBody @Valid AddressAddRequest request) {
        return AddressConverter.convertToResponse(addressService.addAddress(request));
    }

    @GetMapping(GET_ADDRESS)
    public AddressResponse getAddress(@PathVariable Long id) {
        return AddressConverter.convertToResponse(addressService.getAddress(id));
    }

    @PutMapping(UPDATE_ADDRESS)
    public AddressResponse updateAddress(@PathVariable Long id,
                                         @RequestBody @Valid AddressUpdateRequest request) {
        return AddressConverter.convertToResponse(addressService.updateAddress(id, request));
    }

    @DeleteMapping(DELETE_ADDRESS)
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }

    @GetMapping(GET_ALL_ADDRESS_BY_MEMBER_ID)
    public List<AddressResponse> getAllAddressByMemberId(@PathVariable Long id) {
        List<AddressEntity> addresses = addressService.getAllAddressByMemberId(id);
        return AddressConverter.convertToResponse(addresses);
    }

    @GetMapping(GET_ADDRESS_LENGTH_BY_MEMBER_ID)
    public int getAddressLength(@PathVariable Long id) {
        return addressService.findAddressLengthByMemberId(id);
    }
}
