package com.trestman.api.petshop.repository;

import com.trestman.api.petshop.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
