package br.edu.infnet.model.test;
import br.edu.infnet.model.domain.Solicitante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SolicitanteTeste {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/solicitantes.json"));
            for (String line : lines) {
                String[] parts = line.split(" - ");
                String nome = parts[0];
                String cpf = parts[1];
                String email = parts[2];
                Solicitante solicitante = new Solicitante(nome, cpf, email);
                System.out.println("Solicitante: " + solicitante.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}