package com.trestman.api.petshop.dao;

import com.trestman.api.petshop.entity.ItemEntity;
import com.trestman.api.petshop.exception.EntityNotFoundException;
import com.trestman.api.petshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDao {
    
    private ItemRepository itemRepository;
    
    @Autowired
    public ItemDao(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemEntity retrieve(Integer id) throws EntityNotFoundException {
        ItemEntity itemEntity = this.itemRepository.findOne(id);
        if (itemEntity == null) {
            throw new EntityNotFoundException(id, "ItemEntity not found.");
        }
        return itemEntity;
    }

    public List<ItemEntity> retrieve() {
        List<ItemEntity> itemEntities = this.itemRepository.findAll();
        return itemEntities;
    }
    
}
