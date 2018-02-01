package com.trestman.api.petshop.dao;

import com.trestman.api.petshop.entity.AddressEntity;
import com.trestman.api.petshop.exception.EntityNotFoundException;
import com.trestman.api.petshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressDao {
    private AddressRepository addressRepository;

    @Autowired
    public AddressDao(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressEntity add(AddressEntity addressEntity) {
        AddressEntity addedAddressEntity = this.addressRepository.saveAndFlush(addressEntity);

        return addedAddressEntity;
    }

    public AddressEntity retrieve(Integer id) throws EntityNotFoundException {
        AddressEntity addressEntity = this.addressRepository.findOne(id);
        if (addressEntity == null) {
            throw new EntityNotFoundException(id, "AddressEntity not found.");
        }
        return addressEntity;
    }

    public List<AddressEntity> retrieve() {
        List<AddressEntity> addressEntities = this.addressRepository.findAll();
        return addressEntities;
    }

    @Transactional
    public AddressEntity update(Integer id, AddressEntity addressEntity) throws EntityNotFoundException {
        if(!this.addressRepository.exists(id)) {
            throw new EntityNotFoundException(addressEntity.getAddressid(), "AddressEntity not found.");
        }
        addressEntity.setAddressid(id);
        AddressEntity addressEntityUpdated = this.addressRepository.saveAndFlush(addressEntity);
        return addressEntityUpdated;
    }

    @Transactional
    public void remove(Integer id) throws EntityNotFoundException {
        AddressEntity addressEntity = this.addressRepository.findOne(id);
        if(addressEntity == null) {
            throw new EntityNotFoundException(id, "AddressEntity not found.");
        }
        this.addressRepository.delete(id);
    }
}
