package com.bilgeadamboost.springbootcartservice.repository;

import com.bilgeadamboost.springbootcartservice.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    Optional<List<AddressEntity>> findAllByMemberId(Long id);

    @Query(
            value = "SELECT COUNT(*) FROM addresses WHERE member_id = :memberId",
            nativeQuery = true
    )
    int findAddressLengthByMemberId(@Param("memberId") Long id);
}
