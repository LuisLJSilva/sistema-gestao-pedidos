package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Solicitante;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SolicitanteTeste {

    public static void escreverSolicitante(String fileName, Solicitante solicitante) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { // Adicionado o true para não sobrescrever o arquivo
            writer.write("Solicitante: Nome: " + solicitante.getNome() + ", CPF: " + solicitante.getCpf() + ", Email: " + solicitante.getEmail());
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/solicitantes.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Solicitante> solicitantes = objectMapper.readValue(jsonContent, new TypeReference<List<Solicitante>>() {});

            String saidaArquivo = "src/main/resources/saida_solicitante.txt";
            for (Solicitante solicitante : solicitantes) {
                System.out.println("Solicitante: " + solicitante.toString());
                escreverSolicitante(saidaArquivo, solicitante);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
