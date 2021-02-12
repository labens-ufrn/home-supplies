package br.ufrn.bsi.supplies.service.cep;

public enum CepApi {

    VIA_CEP("http://viacep.com.br/ws/"),
    BRASIL_API_CEP("https://brasilapi.com.br/api/cep/v1/");

    private String urlBase;

    CepApi(String urlBase) {
        this.urlBase = urlBase;
    }

    public String getUrlCep(String cep) {
        if (this == VIA_CEP) {
            return this.urlBase + cep + "/json";
        }
        return this.urlBase + cep;
    }
}
