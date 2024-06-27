package br.com.alura.modulos;//Tratar os dados JSON obtidos pela API, retornar apenas dados necessários da aplicação

public record DadosDaAPI(String base_code, String target_code, Double conversion_rate, Double conversion_result) {
}