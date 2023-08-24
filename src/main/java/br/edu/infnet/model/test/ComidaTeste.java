package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Comida;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ComidaTeste {

    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/comidas.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Comida> comidas = objectMapper.readValue(jsonContent, new TypeReference<List<Comida>>() {});

            String saidaArquivo = "src/main/resources/saida_comida.txt";
            for (Comida comida : comidas) {
                System.out.println("Comida: " + comida.toString());
                comida.imprimirComida(saidaArquivo); // Gravando em um arquivo específico
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
