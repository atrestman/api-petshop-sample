package com.trestman.api.petshop.mapper;

import com.trestman.api.petshop.entity.ItemEntity;
import com.trestman.swagger.api.petshop.model.Address;
import com.trestman.swagger.api.petshop.model.Pet;
import com.trestman.swagger.api.petshop.model.Product;
import com.trestman.swagger.api.petshop.model.Seller;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemMapper {
    
    private static Function<ItemEntity, Pet> mapItemEntityIntoPet =
            new Function<ItemEntity, Pet>() {
                @Override
                public Pet apply(ItemEntity itemEntity) {
                    Pet pet = new Pet();
                    pet.petid(itemEntity.getItemid())
                            .name(itemEntity.getName())
                            .description(itemEntity.getDescription())
                            .imageurl(itemEntity.getImageurl())
                            .price(itemEntity.getPrice().floatValue())
                            .totalscore(itemEntity.getTotalscore())
                            .numberofvotes(itemEntity.getNumberofvotes())
                            .disabled(itemEntity.getDisabled())
                            .address(AddressMapper.map(itemEntity.getAddressEntity()))
                            .seller(SellerMapper.map(itemEntity.getSellerEntity()))
                            .product(ProductMapper.map(itemEntity.getProductEntity()));
                    return pet;
                }
            };

    private static Function<Pet, ItemEntity> mapPetIntoPetEntity =
            new Function<Pet, ItemEntity>() {
                @Override
                public ItemEntity apply(Pet pet) {
                    ItemEntity itemEntity = ItemEntity.builder()
                            .itemid(pet.getPetid())
                            .name(pet.getName())
                            .description(pet.getDescription())
                            .imageurl(pet.getImageurl())
                            .price(new BigDecimal(pet.getPrice()))
                            .totalscore(pet.getTotalscore())
                            .numberofvotes(pet.getNumberofvotes())
                            .disabled((pet.getDisabled()))
                            .build();
                    itemEntity.setAddressEntity(AddressMapper.map(pet.getAddress()));
                    itemEntity.setSellerEntity(SellerMapper.map(pet.getSeller()));
                    itemEntity.setProductEntity(ProductMapper.map(pet.getProduct()));
                    return itemEntity;
                }
            };


    public static ItemEntity map(Pet item) {
        if (item == null) {
            return null;
        }
        return mapPetIntoPetEntity.apply(item);
    }

    public static Pet map(ItemEntity itemEntity) {
        if (itemEntity == null) {
            return null;
        }
        return mapItemEntityIntoPet.apply(itemEntity);
    }

    public static List<Pet> map(List<ItemEntity> itemEntities) {
        List<Pet> items = itemEntities.stream().map(mapItemEntityIntoPet)
                .collect(Collectors.toList());
        return items;
    }
}
