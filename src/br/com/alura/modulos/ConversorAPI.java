package br.com.alura.modulos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {

    int codigoDeConversao;
    double valorAConverter;
    String moedaInicial;
    String moedaFinal;

    //Módulo de requisição para 'ExchangeRate-API' e conversão de valores
    public void ativarConversor(int codigoDeConversao, double valorAConverter) throws IOException, InterruptedException {
        this.codigoDeConversao = codigoDeConversao;
        this.valorAConverter = codigoDeConversao;

        //Modificar requisição conforme moeda escolhida para conversão
        switch (codigoDeConversao) {
            case 1 -> {
                moedaInicial = "USD";
                moedaFinal = "ARS";
            }
            case 2 -> {
                moedaInicial = "ARS";
                moedaFinal = "USD";
            }
            case 3 -> {
                moedaInicial = "USD";
                moedaFinal = "BRL";
            }
            case 4 -> {
                moedaInicial = "BRL";
                moedaFinal = "USD";
            }
            case 5 -> {
                moedaInicial = "USD";
                moedaFinal = "COP";
            }
            case 6 -> {
                moedaInicial = "COP";
                moedaFinal = "USD";
            }
        }

        //Chamar API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/a8d0a2e47f8bfef1b9db3c28/pair/" + moedaInicial + "/" + moedaFinal + "/" + valorAConverter)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Tratar JSON conforme configuração em Record
        Gson novoGSON = new GsonBuilder().setPrettyPrinting().create();
        String arquivoJSONdaAPI = (response.body());
        DadosDaAPI resultadosDaAPI = novoGSON.fromJson(arquivoJSONdaAPI, DadosDaAPI.class);

        //Mostrar resultado
        System.out.println("""
                O valor de %.2f %s é equivalente a %.2f %s. 
                A taxa de conversão é de %.2f por unidade.
                """.formatted(valorAConverter, resultadosDaAPI.base_code(), resultadosDaAPI.conversion_result(), resultadosDaAPI.target_code(), resultadosDaAPI.conversion_rate()));
    }
}