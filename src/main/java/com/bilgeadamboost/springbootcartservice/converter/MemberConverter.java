package com.bilgeadamboost.springbootcartservice.converter;

import com.bilgeadamboost.springbootcartservice.model.dto.request.MemberAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.MemberResponse;
import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;
import com.bilgeadamboost.springbootcartservice.model.enums.Gender;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberEntity convertToMember(MemberAddRequest request) {
        if (request == null)
            return null;

        //todo age metod dışına taşınabilir -
        return MemberEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .age(String.valueOf(new Date().getYear() - request.getBirthOfDate().getYear()))
                .birthOfDate(request.getBirthOfDate())
                .gender(convertToGender(request.getGender()))
                .isActive(true)
                .createdDate(new Date())
                .build();
    }

    public static MemberResponse convertToResponse(MemberEntity member) {
        if (member == null)
            return null;

        return MemberResponse.builder()
                .id(member.getId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .age(member.getAge())
                .birthOfDate(member.getBirthOfDate())
                .gender(member.getGender())
                .isActive(member.isActive())
                .build();
    }

    public static List<MemberResponse> convertToResponse(List<MemberEntity> members) {
        if (members.isEmpty())
            return Collections.emptyList();

        return members.stream()
                .map(MemberConverter::convertToResponse)
                .collect(Collectors.toList());
    }

    private static Gender convertToGender(String gender) {
        if (gender == null)
            return null;

        return switch (gender) {
            case "MALE" -> Gender.MALE;
            case "FEMALE" -> Gender.FEMALE;
            default -> null;
        };
    }
}
