package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Sobremesa;

public class SobremesaTeste {
    public static void main(String[] args) {
        Sobremesa bolo = new Sobremesa("Bolo", 20.0f, 102, 1.0f, true, "Chocolate");
        System.out.println("Sobremesa 1: " + bolo.toString());

        Sobremesa sorvete = new Sobremesa("Sorvete", 8.0f, 103, 0.5f, true, "Baunilha");
        System.out.println("Sobremesa 2: " + sorvete.toString());

        Sobremesa pudim = new Sobremesa("Pudim", 10.0f, 104, 0.6f, true, "Leite condensado");
        System.out.println("Sobremesa 3: " + pudim.toString());
    }
}
