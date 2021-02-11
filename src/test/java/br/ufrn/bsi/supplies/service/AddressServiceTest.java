package br.ufrn.bsi.supplies.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.address.AddressService;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    AddressService addressService;

    @Test
    public void testGetAddress() {
        Optional<Address> address = addressService.search("59300000");
        assertEquals("Caicó", address.get().getCity());
        assertEquals("RN", address.get().getState());
        address = addressService.search("59300000");
    }
}
