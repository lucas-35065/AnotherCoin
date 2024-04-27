package br.com.lucas.anothercoin.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import br.com.lucas.anothercoin.modelos.Calculos;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException, RuntimeException {
        var apiKey = "673756d16a9c26874419944b";
        var url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
        Scanner leitura = new Scanner(System.in);
        Calculos calculos = new Calculos();

        Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

        String valor = "Digite o valor que você tem na moeda escolhida: "; 

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
            
            HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
            
            var json = response.body();

            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            var opcao = 0;

            while (opcao != 11) {
                double dinheiro = 0;
                
                opcao = leitura.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("ARS").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Pesos Argentinos equivalem a: $" 
                        + calculos.conversaoParaOutrasMoedas(dinheiro) + "\n");
                        break;

                    case 2:
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("ARS").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Dólares equivalem a: AR$" 
                        + calculos.conversaoParaDolar(dinheiro) + "\n");
                        break;

                    case 3: 
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("BOB").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Bolivianos equivalem a: $" 
                        + calculos.conversaoParaOutrasMoedas(dinheiro) + "\n");
                        break;
                    
                    case 4:
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("BOB").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Dólares equivalem a: Bs" 
                        + calculos.conversaoParaDolar(dinheiro) + "\n");
                        break;
                    
                    case 5: 
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("BRL").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Reais equivalem a: $" 
                        + calculos.conversaoParaOutrasMoedas(dinheiro) + "\n");
                        break;
                    
                    case 6:
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("BRL").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Dólares equivalem a: R$" 
                        + calculos.conversaoParaDolar(dinheiro) + "\n");
                        break;
                    
                    case 7:
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("CLP").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Pesos chilenos equivalem a: $" 
                        + calculos.conversaoParaOutrasMoedas(dinheiro) + "\n");
                        break;
                    
                    case 8:
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("CLP").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Dólares equivalem a: CLP$" 
                        + calculos.conversaoParaDolar(dinheiro) + "\n");
                        break;
                    
                    case 9:
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("CAD").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Dólares Canadenses equivalem a: $" 
                        + calculos.conversaoParaOutrasMoedas(dinheiro) + "\n");
                        break;
                    
                    case 10:    
                        System.out.println(valor);
                        dinheiro = leitura.nextInt();

                        calculos.currency = conversionRates.get("CAD").getAsDouble();

                        System.out.println("Hoje, o valor que você tem de Dólares equivalem a: CAD$" 
                        + calculos.conversaoParaDolar(dinheiro) + "\n");
                        break;
                    
                    default: System.out.println("Programa Encerrado! Até mais!");
                        break;
                }
            }

        } catch (IOException | InterruptedException | RuntimeException e) {
            System.out.println("Ocorreu um erro:");
            System.out.println(e.getMessage());
        }
        leitura.close();
    }
}
