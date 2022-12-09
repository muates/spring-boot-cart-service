package com.bilgeadamboost.springbootcartservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberUpdateRequest {

    private String firstName;
    private String lastName;
    private String phone;
}
