package br.com.lucas.anothercoin.modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class Requests {
    private String url = "https://v6.exchangerate-api.com/v6/673756d16a9c26874419944b/pair/";
    public String currencyCodeFrom;
    public String currencyCodeTo;
    public String valor;

    public Requests (String currencyCodeFrom, String currencyCodeTo, String valor){
        this.currencyCodeFrom = currencyCodeFrom;
        this.currencyCodeTo = currencyCodeTo;
        this.valor = valor;
    }

    public String requisicao () throws IOException, InterruptedException {
     HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + currencyCodeFrom + "/" + currencyCodeTo + "/" + valor))
            .build();
            
            HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
    }
}
