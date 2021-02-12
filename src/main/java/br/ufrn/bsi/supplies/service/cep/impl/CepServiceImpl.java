package br.ufrn.bsi.supplies.service.cep.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import com.google.gson.Gson;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.cep.CepApi;
import br.ufrn.bsi.supplies.service.cep.CepService;

@Service
@Primary
public class CepServiceImpl implements CepService {

    private int codigoSucesso = 200;

    @Override
    public Optional<Address> getAddressByCep(String cep, CepApi api) {
        Optional<String> jsonEmString = getAddressJsonByCep(cep, api);

        if (jsonEmString.isPresent()) {
            Address address = extractAddress(jsonEmString.get(), api);
            return Optional.ofNullable(address);
        }
        return Optional.empty();
    }

    private Address extractAddress(String jsonEmString, CepApi api) {
        Gson gson = new Gson();
        Address address = null;
        if (api == CepApi.BRASIL_API_CEP)
            address = gson.fromJson(jsonEmString, Address.class);
        else {
            Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
            address = new Address(endereco.getCep(), endereco.getLocalidade(), endereco.getUf());
        }
        return address;
    }

    @Override
    public Optional<String> getAddressJsonByCep(String cep, CepApi api) {
        String urlApi = api.getUrlCep(cep);

        try {
            HttpURLConnection connection = openConnection(urlApi);
            String jsonString = getJSON(connection);

            return Optional.ofNullable(jsonString);
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            return Optional.empty();
        }
    }

    private static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }

    private HttpURLConnection openConnection(String urlParaChamada) throws MalformedURLException, IOException {
        URL url = new URL(urlParaChamada);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

        if (conexao.getResponseCode() != codigoSucesso)
            throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
        return conexao;
    }

    private String getJSON(HttpURLConnection conexao) throws IOException {
        BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
        String jsonEmString = converteJsonEmString(resposta);
        return jsonEmString;
    }
}
