package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Bebida;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BebidaTeste {

    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/bebidas.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Bebida> bebidas = objectMapper.readValue(jsonContent, new TypeReference<List<Bebida>>() {});

            String saidaArquivo = "src/main/resources/saida_bebida.txt";
            for (Bebida bebida : bebidas) {
                System.out.println("Bebida: " + bebida.toString());
                bebida.imprimirBebida(saidaArquivo); // Gravando em um arquivo específico
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
