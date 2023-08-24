package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Sobremesa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SobremesaTeste {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/sobremesas.jsonjson"));
            for (String line : lines) {
                String[] parts = line.split(" - ");
                String nome = parts[0];
                float valor = Float.parseFloat(parts[1]);
                int codigo = Integer.parseInt(parts[2]);
                float gordura = Float.parseFloat(parts[3]);
                boolean gelada = Boolean.parseBoolean(parts[4]);
                String sabor = parts[5];
                Sobremesa sobremesa = new Sobremesa(nome, valor, codigo, gordura, gelada, sabor);
                System.out.println("Sobremesa: " + sobremesa.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
