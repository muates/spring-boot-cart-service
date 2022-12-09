package com.bilgeadamboost.springbootcartservice.service;

import com.bilgeadamboost.springbootcartservice.model.dto.request.MemberAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.MemberUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;

import java.util.List;

public interface MemberService {
    MemberEntity addMember(MemberAddRequest request);
    MemberEntity getMember(Long id);
    MemberEntity updateMember(Long id, MemberUpdateRequest request);
    void deleteMember(Long id);
    List<MemberEntity> getMembers();
    boolean doesMemberExist(Long id);
}
