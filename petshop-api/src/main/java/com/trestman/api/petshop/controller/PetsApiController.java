package com.trestman.api.petshop.controller;

import com.trestman.api.petshop.dao.ItemDao;
import com.trestman.api.petshop.entity.ItemEntity;
import com.trestman.api.petshop.exception.EntityNotFoundException;
import com.trestman.api.petshop.mapper.ItemMapper;
import com.trestman.swagger.api.petshop.model.Pet;
import com.trestman.swagger.api.petshop.spring.PetsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PetsApiController implements PetsApi {

    private ItemDao itemDao;

    @Autowired
    public PetsApiController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public ResponseEntity<Pet> getPetById(@PathVariable("petId") Integer petId) {
        ItemEntity itemEntity = null;
        try {
            itemEntity = this.itemDao.retrieve(petId);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Pet());
        }
        Pet pet = ItemMapper.map(itemEntity);
        return ResponseEntity.status(HttpStatus.OK).body(pet);
        
    }

    @Override
    public ResponseEntity<List<Pet>> getPets() {
        List<ItemEntity> itemEntities = this.itemDao.retrieve();
        List<Pet> items = ItemMapper.map(itemEntities);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

}
