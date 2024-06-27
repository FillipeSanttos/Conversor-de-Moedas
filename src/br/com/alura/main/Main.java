package br.com.alura.main;

import br.com.alura.modulos.ConversorAPI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean ativarPrograma = true;
        double valorAConverter;

        Scanner novoLeitor = new Scanner(System.in);
        ConversorAPI novoConversor = new ConversorAPI();

        System.out.println("Bem vindo ao Conversor de Moedas!");

        while (ativarPrograma) {
            System.out.println("""
                    *******************************
                    TABELA DE CONVERSÃO:
                                        
                    1 - Dólar para Peso Argentino
                    2 - Peso Argentino para Dólar
                                        
                    3 - Dólar para Real Brasileiro
                    4 - Real Brasileiro para Dólar
                                        
                    5 - Dólar para Peso Colombiano
                    6 - Peso Colombiano para Dólar
                                        
                    7 - Sair
                    *******************************
                                        
                    Digite uma opção válida:""");

            int opcaoDoMenu = novoLeitor.nextInt();

            switch (opcaoDoMenu) {
                case 1, 2, 3, 4, 5, 6 -> {
                    System.out.println("Qual valor você deseja converter?");
                    valorAConverter = novoLeitor.nextDouble();

                    novoConversor.ativarConversor(opcaoDoMenu, valorAConverter);

                    System.out.println("Converter outro valor?");
                    System.out.println("1- Sim  2- Não");
                    var proximaConversao = novoLeitor.next();

                    if (!proximaConversao.equalsIgnoreCase("1")) {
                        ativarPrograma = false;
                    }
                }

                case 7 -> ativarPrograma = false;

                default -> System.out.println("Opção Inválida!");
            }
        }
        System.out.println("Obrigado por utilizar o Conversor de Moedas! :-)");
    }
}
