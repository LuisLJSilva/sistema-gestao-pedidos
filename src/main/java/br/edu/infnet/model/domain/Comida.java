package br.edu.infnet.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Comida extends Produto {
    private float peso;
    private boolean vegano;
    @JsonProperty("ingredientes")
    private String ingredientes;

    public Comida() {
    }


    public Comida(String nome, float valor, int codigo, float peso, boolean vegano, String ingredientes) {
        super(nome, valor, codigo);
        this.peso = peso;
        this.vegano = vegano;
        this.ingredientes = ingredientes;
    }

    public void imprimirComida(String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("Nome da Comida: " + getNome());
            writer.newLine();
            writer.write("Peso: " + peso + "kg");
            writer.newLine();
            writer.write("Vegano: " + (vegano ? "Sim" : "Não"));
            writer.newLine();
            writer.write("Ingredientes: " + ingredientes);
        } catch (IOException e) {
            System.err.println("Erro ao gravar a comida no arquivo: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public float calcularDesconto() {
        return vegano ? getValor() * 0.05f : 0;
    }

    public float getPeso() {
        return peso;
    }

    public boolean isVegano() {
        return vegano;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        String veganoStr = vegano ? "Vegano" : "Não Vegano";
        return super.toString() + " - Peso: " + peso + "kg - " + veganoStr + " - Ingredientes: " + ingredientes;
    }
}
