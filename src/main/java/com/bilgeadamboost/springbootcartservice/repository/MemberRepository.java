package com.bilgeadamboost.springbootcartservice.repository;

import com.bilgeadamboost.springbootcartservice.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
