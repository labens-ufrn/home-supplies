package br.ufrn.bsi.supplies.service.cep.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.cep.CepApi;
import br.ufrn.bsi.supplies.service.cep.CepService;

@Service
public class MockCepService implements CepService {

    public Optional<Address> getAddressByCep(String cep, CepApi api) {
        if (cep.equals("59300000"))
            return Optional.of(AddressConst.CAICO_ADDRESS);
        return Optional.of(AddressConst.NULL_ADDRESS);
    }

    public Optional<String> getAddressJsonByCep(String cep, CepApi api) {
        return Optional.empty();
    }
}

class AddressConst {
    public static final Address CAICO_ADDRESS = new Address("59300000", "RN", "Caicó");
    public static final Address NULL_ADDRESS = new Address("NULL", "NULL", "NULL");
}
