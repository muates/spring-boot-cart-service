package com.bilgeadamboost.springbootcartservice.model.dto.response;

import com.bilgeadamboost.springbootcartservice.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String age;
    private Date birthOfDate;
    private Gender gender;
    private boolean isActive;
}
