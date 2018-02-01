package com.trestman.api.petshop.repository;

import com.trestman.api.petshop.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
