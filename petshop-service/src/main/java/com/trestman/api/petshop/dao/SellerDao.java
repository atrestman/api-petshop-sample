package com.trestman.api.petshop.dao;

import com.trestman.api.petshop.entity.SellerEntity;
import com.trestman.api.petshop.exception.EntityNotFoundException;
import com.trestman.api.petshop.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SellerDao {

    private SellerRepository sellerRepository;

    @Autowired
    public SellerDao(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerEntity add(SellerEntity sellerEntity) {
        SellerEntity addedSellerEntity = this.sellerRepository.saveAndFlush(sellerEntity);

        return addedSellerEntity;
    }

    public SellerEntity retrieve(Integer id) throws EntityNotFoundException {
        SellerEntity sellerEntity = this.sellerRepository.findOne(id);
        if (sellerEntity == null) {
            throw new EntityNotFoundException(id, "SellerEntity not found.");
        }
        return sellerEntity;
    }

    public List<SellerEntity> retrieve() {
        List<SellerEntity> sellerEntities = this.sellerRepository.findAll();
        return sellerEntities;
    }

    @Transactional
    public SellerEntity update(Integer id, SellerEntity sellerEntity) throws EntityNotFoundException {
        if(!this.sellerRepository.exists(id)) {
            throw new EntityNotFoundException(sellerEntity.getContactinfoid(), "SellerEntity not found.");
        }
        sellerEntity.setContactinfoid(id);
        SellerEntity sellerEntityUpdated = this.sellerRepository.saveAndFlush(sellerEntity);
        return sellerEntityUpdated;
    }

    @Transactional
    public void remove(Integer id) throws EntityNotFoundException {
        SellerEntity sellerEntity = this.sellerRepository.findOne(id);
        if(sellerEntity == null) {
            throw new EntityNotFoundException(id, "SellerEntity not found.");
        }
        this.sellerRepository.delete(id);
    }
}
