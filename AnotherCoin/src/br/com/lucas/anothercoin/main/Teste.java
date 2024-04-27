package br.com.lucas.anothercoin.main;

import java.io.IOException;
import java.util.Scanner;

import br.com.lucas.anothercoin.menus.LilMenu;
import br.com.lucas.anothercoin.menus.Menu;
import br.com.lucas.anothercoin.modelos.Requests;
import br.com.lucas.anothercoin.modelos.Validator;

public class Teste {
    public static void main(String[] args) throws IOException, InterruptedException, RuntimeException {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Validator validator = new Validator();

        int option;

        do {
            menu.showMenu();


            while (!validator.validateOption(scanner.nextLine())) {
                System.out.println("Por favor, insira um número inteiro válido.");
                scanner.next();
            }
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    LilMenu lilMenu = new LilMenu();
                    lilMenu.showNextMenu();
                    Requests requests = new Requests("ARS", "BRL", lilMenu.getValue());
                    System.out.println(requests);
                    break;
            
                default:
                    break;
            }

        } while (option != 0);
        

        
    }
}
