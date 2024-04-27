package br.com.lucas.anothercoin.modelos;

public class Validator {
    public boolean validateOption (String option){
        try {
            Integer.parseInt(option);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateValue (String value){
        return value.matches("[0-9.,]+");
    }
}
