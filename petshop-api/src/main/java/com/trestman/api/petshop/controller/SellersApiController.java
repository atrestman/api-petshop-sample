package com.trestman.api.petshop.controller;

import com.trestman.api.petshop.dao.SellerDao;
import com.trestman.api.petshop.mapper.SellerMapper;
import com.trestman.api.petshop.entity.SellerEntity;
import com.trestman.api.petshop.exception.EntityNotFoundException;
import com.trestman.swagger.api.petshop.model.Seller;
import com.trestman.swagger.api.petshop.spring.SellersApi;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class SellersApiController implements SellersApi {

    private SellerDao sellerDao;

    @Autowired
    public SellersApiController(SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }

    public ResponseEntity<Seller> addSeller(@RequestBody Seller body) {
        SellerEntity sellerEntity = SellerMapper.map(body);
        SellerEntity sellerEntityAdded = this.sellerDao.add(sellerEntity);
        Seller seller = SellerMapper.map(sellerEntityAdded);
        return ResponseEntity.status(HttpStatus.OK).body(seller);
    }

    public ResponseEntity<Void> deleteSeller(@PathVariable("sellerId") Integer sellerId) {
        try {
            this.sellerDao.remove(sellerId);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public  ResponseEntity<Seller> getSellerById(@PathVariable("sellerId") Integer sellerId) {
        SellerEntity sellerEntity = null;
        try {
            sellerEntity = this.sellerDao.retrieve(sellerId);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Seller());
        }
        Seller seller = SellerMapper.map(sellerEntity);
        return ResponseEntity.status(HttpStatus.OK).body(seller);
    }

    public ResponseEntity<List<Seller>> getSellers() {
        List<SellerEntity> sellerEntities = this.sellerDao.retrieve();
        List<Seller> sellers = SellerMapper.map(sellerEntities);
        return ResponseEntity.status(HttpStatus.OK).body(sellers);
    }

    public ResponseEntity<Seller> updateSeller(@PathVariable("sellerId") Integer sellerId,
                                               @RequestBody Seller body) {
        try {
            SellerEntity sellerEntityUpdated = SellerMapper.map(body);
            sellerEntityUpdated = this.sellerDao.update(sellerId, sellerEntityUpdated);
            Seller seller = SellerMapper.map(sellerEntityUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(seller);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Seller());
        }
    }
}
