package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Bebida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class BebidaTeste {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/bebidas.json"));
            for (String line : lines) {
                String[] parts = line.split(" - ");
                String nome = parts[0];
                float valor = Float.parseFloat(parts[1]);
                int codigo = Integer.parseInt(parts[2]);
                boolean alcoolica = Boolean.parseBoolean(parts[3]);
                float volume = Float.parseFloat(parts[4]);
                String marca = parts[5];
                Bebida bebida = new Bebida(nome, valor, codigo, alcoolica, volume, marca);
                System.out.println("Bebida: " + bebida.toString());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}