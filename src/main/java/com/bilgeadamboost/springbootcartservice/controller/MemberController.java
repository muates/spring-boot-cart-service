package com.bilgeadamboost.springbootcartservice.controller;

import com.bilgeadamboost.springbootcartservice.converter.MemberConverter;
import com.bilgeadamboost.springbootcartservice.model.dto.request.MemberAddRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.request.MemberUpdateRequest;
import com.bilgeadamboost.springbootcartservice.model.dto.response.MemberResponse;
import com.bilgeadamboost.springbootcartservice.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadamboost.springbootcartservice.controller.endpoint.MemberControllerEndpoint.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping(ADD_MEMBER)
    public MemberResponse addMember(@RequestBody @Valid MemberAddRequest request) {
        return MemberConverter.convertToResponse(memberService.addMember(request));
    }

    @GetMapping(GET_MEMBER)
    public MemberResponse getMember(@PathVariable Long id) {
        return MemberConverter.convertToResponse(memberService.getMember(id));
    }

    @PutMapping(UPDATE_MEMBER)
    public MemberResponse updateMember(@PathVariable Long id,
                                       @RequestBody MemberUpdateRequest request) {
        return MemberConverter.convertToResponse(memberService.updateMember(id, request));
    }

    @DeleteMapping(DELETE_MEMBER)
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @GetMapping(GET_MEMBERS)
    public List<MemberResponse> getMembers() {
        return MemberConverter.convertToResponse(memberService.getMembers());
    }
}
