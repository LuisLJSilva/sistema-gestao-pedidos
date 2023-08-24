package br.edu.infnet.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Bebida extends Produto {
    private boolean gelada;
    private float tamanho;
    private String marca;

    public Bebida() {
    }

    @JsonCreator
    public Bebida(@JsonProperty("nome") String nome, @JsonProperty("valor") float valor, @JsonProperty("codigo") int codigo, @JsonProperty("gelada") boolean gelada, @JsonProperty("tamanho") float tamanho, @JsonProperty("marca") String marca) {
        super(nome, valor, codigo);
        this.gelada = gelada;
        if (tamanho <= 0) {
            this.tamanho = 1;
        } else {
            this.tamanho = tamanho;
        }
        this.marca = marca;
    }

    @Override
    public float calcularDesconto() {
        if (gelada) {
            return 0.1f * getValor();
        } else {
            return 0;
        }
    }

    public void imprimirBebida(String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("Nome da Bebida: " + getNome());
            writer.newLine();
            writer.write("Gelada: " + (gelada ? "Sim" : "Não"));
            writer.newLine();
            writer.write("Tamanho: " + tamanho + "ml");
            writer.newLine();
            writer.write("Marca: " + marca);
        } catch (IOException e) {
            System.err.println("Erro ao gravar a bebida no arquivo: " + e.getMessage());
            throw e;
        }
    }

    public boolean isGelada() {
        return gelada;
    }

    public void setGelada(boolean gelada) {
        this.gelada = gelada;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) { this.tamanho = tamanho; }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        String geladaStr = gelada ? "Gelada" : "Não Gelada";
        return super.toString() + " - " + geladaStr + " - Tamanho: " + tamanho + "ml - Marca: " + marca;
    }
}
