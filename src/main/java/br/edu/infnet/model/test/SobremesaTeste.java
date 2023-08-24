package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Sobremesa;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SobremesaTeste {

    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/sobremesas.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Sobremesa> sobremesas = objectMapper.readValue(jsonContent, new TypeReference<List<Sobremesa>>() {});

            String saidaArquivo = "src/main/resources/saida_sobremesa.txt";
            for (Sobremesa sobremesa : sobremesas) {
                System.out.println("Sobremesa: " + sobremesa.toString());
                sobremesa.imprimirSobremesa(saidaArquivo); // Gravando em um arquivo específico
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
