package br.com.lucas.anothercoin.main;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.lucas.anothercoin.menus.MenuArsToBrl;
import br.com.lucas.anothercoin.menus.Menu;
import br.com.lucas.anothercoin.modelos.Requests;
import br.com.lucas.anothercoin.modelos.Validator;
import br.com.lucas.anothercoin.modelos.Conversor;

public class Teste {
    
    public static void main(String[] args) throws IOException, InterruptedException, RuntimeException {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Validator validator = new Validator();
        MenuArsToBrl lilMenu = new MenuArsToBrl();
        Gson gson = new Gson();

        int option;
    
        do {
            menu.showMenuPrincipal();
    
            }
            while (!validator.validateOption(scanner.nextLine())); {
                System.out.println("Por favor, insira um número inteiro válido.");
                scanner.next();
            }
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    String valueFromLilMenu = lilMenu.showNextMenu(); // Obtém o valor da LilMenu
    
                    if (valueFromLilMenu != null) { // Verifica se deseja voltar ao menu anterior
                    Requests requests = new Requests("ARS", "BRL", valueFromLilMenu);
                    String arsToBrl = requests.requisicao();
                    Conversor conversor = gson.fromJson(arsToBrl, Conversor.class);
                    System.out.println(conversor.toString());
                    break;
            }

        } while (option != 0);
        
    }
}
