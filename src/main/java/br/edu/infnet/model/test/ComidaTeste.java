package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Comida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ComidaTeste {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/comidas.json" +
                    ""));
            for (String line : lines) {
                String[] parts = line.split(" - ");
                String nome = parts[0];
                float valor = Float.parseFloat(parts[1]);
                int codigo = Integer.parseInt(parts[2]);
                float gordura = Float.parseFloat(parts[3]);
                boolean vegetariana = Boolean.parseBoolean(parts[4]);
                String ingredientes = parts[5];
                Comida comida = new Comida(nome, valor, codigo, gordura, vegetariana, ingredientes);
                System.out.println("Comida: " + comida.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
