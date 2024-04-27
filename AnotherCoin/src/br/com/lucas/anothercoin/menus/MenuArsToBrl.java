package br.com.lucas.anothercoin.menus;

import java.util.Scanner;

import br.com.lucas.anothercoin.modelos.Requests;
import br.com.lucas.anothercoin.modelos.Validator;

public class MenuArsToBrl {
    public String value;

    public String showNextMenu() {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
    
        do {
            System.out.println("Boa! Você está no conversor da moeda");
            System.out.println("1) Digite o valor ");
            System.out.println("Digite o valor que você tem na moeda escolhida no formato 1,00: ");
    
            String input = scanner.next();
    
            if (input.equals("1")) {
                return null; // Retorna null se desejar voltar ao menu anterior
            } else if (validator.validateValue(input)) {
                return input.replace(',', '.'); // Retorna o valor inserido
            } else {
                System.out.println("Por favor, insira um número válido.");
            }
        } while (true);
    }        


    public String getValue() {
        return value;
    }
}
