package br.ufrn.bsi.supplies.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.address.AddressService;
import br.ufrn.bsi.supplies.service.cep.CepApi;

@SpringBootTest
public class AddressServiceMockitoTest {

    AddressService addressService;

    @BeforeEach
    public void init() {
        addressService = Mockito.mock(AddressService.class);
        when(addressService.search(anyString(), any(CepApi.class)))
            .thenReturn(AddressConst.NULL_ADDRESS);
        when(addressService.search(eq("59300000"), any(CepApi.class)))
            .thenReturn(AddressConst.CAICO_ADDRESS);
    }

    @Test
    public void testGetAddress() {
        Optional<Address> address = addressService.search("59300000", CepApi.BRASIL_API_CEP);
        assertEquals("Caicó", address.get().getCity());
        assertEquals("RN", address.get().getState());
        address = addressService.search("59300000", CepApi.BRASIL_API_CEP);
    }
}

class AddressConst {
    public static final Optional<Address> CAICO_ADDRESS = Optional.of(new Address("59300000", "Caicó", "RN"));
    public static final Optional<Address> NULL_ADDRESS = Optional.of(new Address("NULL", "NULL", "NULL"));
}
