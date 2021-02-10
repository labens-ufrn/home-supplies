package br.ufrn.bsi.supplies.service.address;

import java.util.Optional;

import br.ufrn.bsi.supplies.entity.Address;

public interface AddressService {

    /**
     * Info:
     * Optional class that was introduced in Java 8.
     * https://www.baeldung.com/java-optional
     * https://blog.algaworks.com/chega-de-nullpointerexception/
     * 
     * @param cep
     * @return
     */
    Optional<Address> search(String cep);
    
}
