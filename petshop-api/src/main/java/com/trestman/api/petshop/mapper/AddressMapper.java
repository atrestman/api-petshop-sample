package com.trestman.api.petshop.mapper;

import com.trestman.api.petshop.entity.AddressEntity;
import com.trestman.swagger.api.petshop.model.Address;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressMapper {

    private static Function<AddressEntity, Address> mapAddressEntityIntoAddress =
            new Function<AddressEntity, Address>() {
                @Override
                public Address apply(AddressEntity addressEntity) {
                    Address address = new Address();
                    address.addressid(addressEntity.getAddressid())
                            .street1(addressEntity.getStreet1())
                            .street2(addressEntity.getStreet2())
                            .city(addressEntity.getCity())
                            .state(addressEntity.getState())
                            .zip(addressEntity.getZip())
                            .latitude(addressEntity.getLatitude().floatValue())
                            .longtitude(addressEntity.getLongitude().floatValue());
                    return address;
                }
            };

    private static Function<Address, AddressEntity> mapAddressIntoAddressEntity =
            new Function<Address, AddressEntity>() {
                @Override
                public AddressEntity apply(Address address) {
                    AddressEntity addressEntity = AddressEntity.builder()
                            .addressid(address.getAddressid())
                            .street1(address.getStreet1())
                            .street2(address.getStreet2())
                            .city(address.getCity())
                            .state(address.getState())
                            .zip(address.getZip())
                            .latitude(new BigDecimal(address.getLatitude()))
                            .longitude(new BigDecimal(address.getLongtitude()))
                            .build();

                    return addressEntity;
                }
            };

    public static AddressEntity map(Address address) {
        if (address == null) {
            return null;
        }
        return mapAddressIntoAddressEntity.apply(address);
    }

    public static Address map(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        return mapAddressEntityIntoAddress.apply(addressEntity);
    }

    public static List<Address> map(List<AddressEntity> addressEntities) {
        List<Address> addresses = addressEntities.stream().map(mapAddressEntityIntoAddress)
                .collect(Collectors.toList());
        return addresses;
    }
}
