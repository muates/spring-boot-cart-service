package com.bilgeadamboost.springbootcartservice.repository;

import com.bilgeadamboost.springbootcartservice.model.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
