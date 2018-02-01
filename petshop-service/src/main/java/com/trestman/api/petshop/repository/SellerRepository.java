package com.trestman.api.petshop.repository;

import com.trestman.api.petshop.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {
}
