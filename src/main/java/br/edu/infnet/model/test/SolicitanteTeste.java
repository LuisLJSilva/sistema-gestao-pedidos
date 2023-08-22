package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Solicitante;

public class SolicitanteTeste {
    public static void main(String[] args) {
        Solicitante joao = new Solicitante("João", "123.456.789-00", "joao@email.com");
        System.out.println("Solicitante 1: " + joao.toString());

        Solicitante ana = new Solicitante("Ana", "321.654.987-00", "ana@email.com");
        System.out.println("Solicitante 2: " + ana.toString());

        Solicitante carlos = new Solicitante("Carlos", "111.222.333-00", "carlos@email.com");
        System.out.println("Solicitante 3: " + carlos.toString());
    }
}
