package com.bilgeadamboost.springbootcartservice.service.impl;

import com.bilgeadamboost.springbootcartservice.converter.MemberConverter;
import com.bilgeadamboost.springbootcartservice.exception.GlobalException;
import com.bilgeadamboost.springbootcartservice.model.dto.request.MemberAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.MemberUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;
import com.bilgeadamboost.springbootcartservice.repository.MemberRepository;
import com.bilgeadamboost.springbootcartservice.service.MemberService;
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
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberEntity addMember(MemberAddRequest request) {
        return memberRepository.save(MemberConverter.convertToMember(request));
    }

    @Override
    public MemberEntity getMember(Long id) {
        Optional<MemberEntity> member = memberRepository.findById(id);

        if (member.isEmpty())
            throw new GlobalException("Kullanıcı bulunamadı!!", HttpStatus.NOT_FOUND);

        return member.get();
    }

    @Override
    public MemberEntity updateMember(Long id, MemberUpdateRequest request) {
        MemberEntity member = getMember(id);

        checkUpdate(request, member);

        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<MemberEntity> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public boolean doesMemberExist(Long id) {
        return memberRepository.existsById(id);
    }

    private void checkUpdate(MemberUpdateRequest request, MemberEntity member) {
        if (request.getFirstName() != null)
            member.setFirstName(request.getFirstName());
        if (request.getLastName() != null)
            member.setLastName(request.getLastName());
        if (request.getPhone() != null)
            member.setPhone(request.getPhone());

        member.setUpdatedDate(new Date());
    }
}
