package br.ufrn.bsi.supplies.service.cep;

import java.util.Optional;

import br.ufrn.bsi.supplies.entity.Address;

/**
 * The standard term in Brazil; CEP is an acronym for código de endereçamento postal (postal addressing code).
 */
public interface CepService {

    /**
     * Returns the address from the zip string (eg 59300-000). 
     * The dash in cep is optional. 
     * @param cep A postal code
     * @return the address by cep
     */
 
    public Optional<Address> getAddressByCep(String cep, CepApi api);

    /**
     * Returns the address in json format from the cep string (eg 59300-000). 
     * The dash in cep is optional. 
     * Info:
     * https://medium.com/swlh/getting-json-data-from-a-restful-api-using-java-b327aafb3751
     * https://www.baeldung.com/httpurlconnection-post
     * https://www.baeldung.com/jackson
     * @param cep A postal code
     * @return the address in a string in json format. 
     */
    public Optional<String> getAddressJsonByCep(String cep, CepApi api);
    
}
