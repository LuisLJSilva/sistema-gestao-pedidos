package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Comida;

public class ComidaTeste {
    public static void main(String[] args) {
        Comida lasanha = new Comida("Lasanha", 15.0f, 101, 0.5f, false, "Massa, queijo, molho");
        System.out.println("Comida 1: " + lasanha.toString());

        Comida sushi = new Comida("Sushi", 20.0f, 102, 0.2f, true, "Arroz, peixe, alga");
        System.out.println("Comida 2: " + sushi.toString());

        Comida pizza = new Comida("Pizza", 12.0f, 103, 0.4f, false, "Massa, queijo, tomate");
        System.out.println("Comida 3: " + pizza.toString());
    }
}
