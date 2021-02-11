package br.ufrn.bsi.supplies.service.address.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.repository.AddressRepository;
import br.ufrn.bsi.supplies.service.address.AddressService;
import br.ufrn.bsi.supplies.service.brasilapi.BrasilApiService;

@Service
@Primary
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BrasilApiService api;

    @Override
    public Optional<Address> search(String cep) {
        // Busca no Banco de Dados
        Optional<Address> optionalAddress = addressRepository.findByCep(cep);
        /*
        if (  address == null) {
            optionalAddress = Optional.empty();
        } else {
            optionalAddress = Optional.of(address);
        }*/

        if (!optionalAddress.isPresent()) {
            optionalAddress = api.getAddressByCep(cep);
            addressRepository.save(optionalAddress.get());
        }

        return optionalAddress;
    }
}
