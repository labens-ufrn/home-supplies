package br.ufrn.bsi.supplies.service;

import java.util.Optional;

import br.ufrn.bsi.supplies.entity.Address;

public interface BrasilApiService {

    public Optional<Address> getAddressByCep(String cep);

    /**
     * Retorna um Objeto JSON.
     * Info:
     * https://medium.com/swlh/getting-json-data-from-a-restful-api-using-java-b327aafb3751
     * https://www.baeldung.com/httpurlconnection-post
     * https://www.baeldung.com/jackson
     * @param cep
     * @return
     */
    // TODO Pesquisar a melhor api para tratar com JSON.
    public Optional<String> getAddressJsonByCep(String cep);
    
}
