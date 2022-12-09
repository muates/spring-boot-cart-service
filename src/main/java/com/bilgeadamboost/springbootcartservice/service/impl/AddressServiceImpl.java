package com.bilgeadamboost.springbootcartservice.service.impl;

import com.bilgeadamboost.springbootcartservice.converter.AddressConverter;
import com.bilgeadamboost.springbootcartservice.exception.GlobalException;
import com.bilgeadamboost.springbootcartservice.model.dto.request.AddressAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.AddressUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.entity.AddressEntity;
import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;
import com.bilgeadamboost.springbootcartservice.repository.AddressRepository;
import com.bilgeadamboost.springbootcartservice.service.AddressService;
import com.bilgeadamboost.springbootcartservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MemberService memberService;

    @Override
    public AddressEntity addAddress(AddressAddRequest request) {
        int length = addressRepository.findAddressLengthByMemberId(request.getMember().getId());

        if (length > 2)
            throw new GlobalException("Address listesi dolu!!!", HttpStatus.BAD_REQUEST);

        //todo member id tekrardan gözden geçirilecek

        return addressRepository.save(AddressConverter.convertToAddress(request));
    }

    @Override
    public AddressEntity getAddress(Long id) {
        Optional<AddressEntity> address = addressRepository.findById(id);

        if (address.isEmpty())
            throw new GlobalException("Address bulunamadu!!", HttpStatus.NOT_FOUND);

        return address.get();
    }

    @Override
    public AddressEntity updateAddress(Long id, AddressUpdateRequest request) {
        AddressEntity address = getAddress(id);

        checkUpdate(request, address);

        return address;
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<AddressEntity> getAllAddressByMemberId(Long id) {
        Optional<List<AddressEntity>> addresses = addressRepository.findAllByMemberId(id);

        if (addresses.isEmpty())
            throw new GlobalException("Addresler bulunamadı!!", HttpStatus.NOT_FOUND);

        return addresses.get();
    }

    @Override
    public int findAddressLengthByMemberId(Long id) {

        List<AddressEntity> addresses = addressRepository.findAll();

        return addresses.stream()
                .filter(address -> Objects.equals(address.getMember().getId(), id))
                .toList()
                .size();
    }

    private static void checkUpdate(AddressUpdateRequest request, AddressEntity address) {
        if (request.getAddressName() != null) address.setAddressName(request.getAddressName());
        if (request.getCountry() != null) address.setCountry(request.getCountry());
        if (request.getCity() != null) address.setCity(request.getCity());
        if (request.getNeighbourhood() != null) address.setNeighbourhood(request.getNeighbourhood());
        if (request.getStreet() != null) address.setStreet(request.getStreet());
        if (request.getAddress() != null) address.setAddress(request.getAddress());
        address.setUpdatedDate(new Date());
    }
}
