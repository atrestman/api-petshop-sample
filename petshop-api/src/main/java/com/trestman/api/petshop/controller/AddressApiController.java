package com.trestman.api.petshop.controller;

import com.trestman.api.petshop.dao.AddressDao;
import com.trestman.api.petshop.mapper.AddressMapper;
import com.trestman.api.petshop.entity.AddressEntity;
import com.trestman.api.petshop.exception.EntityNotFoundException;
import com.trestman.swagger.api.petshop.model.Address;
import com.trestman.swagger.api.petshop.spring.AddressesApi;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AddressApiController implements AddressesApi {

    private AddressDao addressDao;

    @Autowired
    public AddressApiController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public ResponseEntity<Address> addAddress(@RequestBody Address body) {
        AddressEntity addressEntity = AddressMapper.map(body);
        AddressEntity addressEntityAdded = this.addressDao.add(addressEntity);
        Address address = AddressMapper.map(addressEntityAdded);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @Override
    public ResponseEntity<Void> deleteAddress(@PathVariable("addressId") Integer addressId) {
        try {
            this.addressDao.remove(addressId);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @Override
    public  ResponseEntity<Address> getAddressById(@PathVariable("addressId") Integer addressId) {
        AddressEntity addressEntity = null;
        try {
            addressEntity = this.addressDao.retrieve(addressId);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Address());
        }
        Address address = AddressMapper.map(addressEntity);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @Override
    public ResponseEntity<List<Address>> getAddress() {
        List<AddressEntity> addressEntities = this.addressDao.retrieve();
        List<Address> addresss = AddressMapper.map(addressEntities);
        return ResponseEntity.status(HttpStatus.OK).body(addresss);
    }

    @Override
    public ResponseEntity<Address> updateAddress(@PathVariable("addressId") Integer addressId,
                                                 @RequestBody Address body) {
        try {
            AddressEntity addressEntityUpdated = AddressMapper.map(body);
            addressEntityUpdated = this.addressDao.update(addressId, addressEntityUpdated);
            Address address = AddressMapper.map(addressEntityUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(address);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Address());
        }
    }

}
