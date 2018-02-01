package com.trestman.client.petshop;

import com.trestman.client.ApiClient;
import com.trestman.client.ApiException;
import com.trestman.client.Configuration;
import com.trestman.client.petshop.model.Address;
import com.trestman.client.petshop.model.Pet;
import com.trestman.client.petshop.model.Seller;

import java.util.List;

public class PetshopApiClient {

    private final AddressApi addressApi = new AddressApi();
    private final SellerApi sellerApi = new SellerApi();
    private final PetApi petApi = new PetApi();

    public PetshopApiClient() {
        ApiClient apiClient = Configuration.getDefaultApiClient();

        apiClient.setBasePath("http://localhost:8080/");
    }

    public List<Address> getAddresses() throws ApiException {
        return addressApi.getAddress();
    }

    public List<Seller> getSellers() throws ApiException {
        return sellerApi.getSellers();
    }

    public List<Pet> getPets() throws ApiException {
        return petApi.getPets();
    }
}
