package com.bilgeadamboost.springbootcartservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_name", length = 30)
    private String addressName;

    @Column(name = "country", length = 30)
    private String country;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "neighbourhood", length = 30)
    private String neighbourhood;

    @Column(name = "street", length = 30)
    private String street;

    @Column(name = "postal_code", length = 5)
    private String postalCode;

    @Column(name = "address", length = 100)
    private String address;

    @ManyToOne
    @JsonBackReference
    private MemberEntity member;
}
