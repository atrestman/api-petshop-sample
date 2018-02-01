package com.trestman.api.petshop.mapper;

import com.trestman.api.petshop.entity.SellerEntity;
import com.trestman.swagger.api.petshop.model.Seller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SellerMapper {

    private static Function<SellerEntity, Seller> mapSellerEntityIntoSeller =
            new Function<SellerEntity, Seller>() {
                @Override
                public Seller apply(SellerEntity sellerEntity) {
                    Seller seller = new Seller();
                    seller.contactinfoid(sellerEntity.getContactinfoid())
                            .firstname(sellerEntity.getFirstname())
                            .lastname(sellerEntity.getLastname())
                            .email(sellerEntity.getEmail());
                    return seller;
                }
            };

    private static Function<Seller, SellerEntity> mapSellerIntoSellerEtntity =
            new Function<Seller, SellerEntity>() {
                @Override
                public SellerEntity apply(Seller seller) {
                    SellerEntity sellerEntity = SellerEntity.builder()
                            .contactinfoid(seller.getContactinfoid())
                            .firstname(seller.getFirstname())
                            .lastname(seller.getLastname())
                            .email(seller.getEmail())
                            .build();
                    return sellerEntity;
                }
            };


    public static SellerEntity map(Seller seller) {
        if (seller == null) {
            return null;
        }
        return mapSellerIntoSellerEtntity.apply(seller);
    }

    public static Seller map(SellerEntity sellerEntity) {
        if (sellerEntity == null) {
            return null;
        }
        return mapSellerEntityIntoSeller.apply(sellerEntity);
    }

    public static List<Seller> map(List<SellerEntity> sellerEntities) {
        List<Seller> sellers = sellerEntities.stream().map(mapSellerEntityIntoSeller)
                .collect(Collectors.toList());
        return sellers;
    }
}
