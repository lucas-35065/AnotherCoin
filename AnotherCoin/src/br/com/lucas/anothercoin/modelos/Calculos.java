package br.com.lucas.anothercoin.modelos;

public class Calculos {
    public double currency;

    public double conversaoParaDolar (double dinheiro) {
        return this.currency*dinheiro;
    }

    public double conversaoParaOutrasMoedas (double dinheiro){
        return dinheiro/currency;
    }
}
