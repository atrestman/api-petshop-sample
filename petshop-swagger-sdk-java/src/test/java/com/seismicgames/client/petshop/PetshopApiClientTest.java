package com.trestman.client.petshop;

import com.trestman.client.ApiException;
import com.trestman.client.petshop.model.Address;
import com.trestman.client.petshop.model.Pet;
import com.trestman.client.petshop.model.Seller;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Ignore
public class PetshopApiClientTest {
    private PetshopApiClient petshopApiClient = new PetshopApiClient();

    @Test
    public void getAddressTest() throws ApiException {
        List<Address> addresses = petshopApiClient.getAddresses();
        assertNotNull(addresses);
        assertTrue(addresses.size() > 0);
    }

    @Test
    public void getSellersTest() throws ApiException {
        List<Seller> sellers = petshopApiClient.getSellers();
        assertNotNull(sellers);
        assertTrue(sellers.size() > 0);
    }

    @Test
    public void getPetsTest() throws ApiException {
        List<Pet> pets = petshopApiClient.getPets();
        assertNotNull(pets);
        assertTrue(pets.size() > 0);
    }
}
