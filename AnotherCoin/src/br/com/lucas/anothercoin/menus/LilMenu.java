package br.com.lucas.anothercoin.menus;

import java.util.Scanner;

import br.com.lucas.anothercoin.modelos.Requests;
import br.com.lucas.anothercoin.modelos.Validator;

public class LilMenu {
    public String value;

    public void showNextMenu (){
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        double option;

        do {
            System.out.println("Boa! Você está no conversor da moeda");
            System.out.println("Caso queira voltar ao menu anterior, digite 1");
            System.out.println("Digite o valor que você tem na moeda escolhida no formato 1,00: ");

            option = Integer.parseInt(scanner.next());

            if (option != 1) {
                do {
                    this.value = scanner.next();
                    if (!validator.validateValue(this.value)) {
                        System.out.println("Por favor, insira um número válido.");
                        System.out.println("Digite o valor que você tem na moeda escolhida no formato 1,00: ");
                    }
                } while (!validator.validateValue(this.value));
    
                this.value = value.replace(',', '.');
            } else {
                return;
            } 
        } while (true);
        
    }


    public String getValue() {
        return value;
    }
}
