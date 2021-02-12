package br.ufrn.bsi.supplies.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.cep.CepApi;
import br.ufrn.bsi.supplies.service.cep.impl.CepServiceImpl;

@SpringBootTest
public class CepServiceTest {

    @Autowired
    private CepServiceImpl api;

    @Test
    public void findAddressViaCep() {
        String cep = "59300000";
        Optional<Address> endereco = api.getAddressByCep(cep, CepApi.VIA_CEP);
        assertEquals("Caicó", endereco.get().getCity());
    }

    @Test
    public void findAddressBrasilApi() {
        String cep = "59300000";
        Optional<Address> endereco = api.getAddressByCep(cep, CepApi.BRASIL_API_CEP);
        assertEquals("Caicó", endereco.get().getCity());
    }

    @Test
    public void buscaAddressPorCep2() {
        String cep = "58705150";
        Optional<Address> endereco = api.getAddressByCep(cep, CepApi.BRASIL_API_CEP);
        assertEquals("Patos", endereco.get().getCity());
    }
}
