package br.edu.infnet.model.domain;

import br.edu.infnet.model.domain.exceptions.ComidaInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Comida extends Produto {
    private float peso;
    private boolean vegano;
    @JsonProperty("ingredientes")
    private String ingredientes;

    public Comida() {
    }

    @JsonCreator
    public Comida(
            @JsonProperty("nome") String nome,
            @JsonProperty("valor") float valor,
            @JsonProperty("codigo") int codigo,
            @JsonProperty("peso") float peso,
            @JsonProperty("vegano") boolean vegano,
            @JsonProperty("ingredientes") String ingredientes,
            @JsonProperty("categorias") Set<String> categorias
    ) throws ComidaInvalidaException {
        super(nome, valor, codigo, categorias);

        if (peso <= 0) {
            throw new ComidaInvalidaException("O peso da comida deve ser maior que zero.");
        }
        this.peso = peso;

        this.vegano = vegano;
        this.ingredientes = ingredientes;
    }

    @Override
    public float calcularDesconto() {
        return vegano ? getValor() * 0.05f : 0;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        String veganoStr = vegano ? "Vegano" : "Não Vegano";
        return super.toString() + " - Peso: " + peso + "kg - " + veganoStr + " - Ingredientes: " + ingredientes;
    }
}
