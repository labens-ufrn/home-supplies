package br.ufrn.bsi.supplies.service.address.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.address.AddressService;
import br.ufrn.bsi.supplies.service.cep.CepApi;

/**
 * Classe para representar um Mock do AddressService
 */
@Service
public class MockAddressService implements AddressService {

    @Override
    public Optional<Address> search(String cep, CepApi api) {
        if (cep.equals("59300000"))
            return Optional.of(AddressConst.CAICO_ADDRESS);
        return Optional.of(AddressConst.NULL_ADDRESS);
    }
}

class AddressConst {
    public static final Address CAICO_ADDRESS = new Address("59300000", "Caicó", "RN");
    public static final Address NULL_ADDRESS = new Address("NULL", "NULL", "NULL");
}
