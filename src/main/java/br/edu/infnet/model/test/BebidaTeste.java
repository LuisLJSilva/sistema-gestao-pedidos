package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Bebida;

public class BebidaTeste {

    public static void main(String[] args) {
        Bebida cerveja = new Bebida("Cerveja", 10.0f, 123, true, 500f, "Skol");
        System.out.println("Bebida 1: " + cerveja.toString());

        Bebida refrigerante = new Bebida("Refrigerante", 5.0f, 456, false, 350f, "Coca-Cola");
        System.out.println("Bebida 2: " + refrigerante.toString());

        Bebida agua = new Bebida("Água", 2.0f, 789, false, 200f, "Crystal");
        System.out.println("Bebida 3: " + agua.toString());
    }
}