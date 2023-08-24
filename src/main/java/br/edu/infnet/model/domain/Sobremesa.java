package br.edu.infnet.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sobremesa extends Produto {
    private float quantidade;
    private boolean doce;
    @JsonProperty("informacao")
    private String informacao;


    public Sobremesa() {
    }


    public Sobremesa(String nome, float valor, int codigo, float quantidade, boolean doce, String informacao) {
        super(nome, valor, codigo);
        this.quantidade = quantidade;
        this.doce = doce;
        this.informacao = informacao;
    }

    public void imprimirSobremesa(String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            super.imprimirProduto(arquivo);
            writer.write("Quantidade: " + quantidade);
            writer.newLine();
            writer.write("Tipo: " + (doce ? "Doce" : "Light"));
            writer.newLine();
            writer.write("Informação: " + informacao);
        } catch (IOException e) {
            System.err.println("Erro ao gravar a sobremesa no arquivo: " + e.getMessage());
            throw e;
        }
    }


    @Override
    public float calcularDesconto() {
        // Implementação específica para Sobremesa
        return doce ? 0.05f * getValor() : 0;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDoce() {
        return doce;
    }

    public void setDoce(boolean doce) {
        this.doce = doce;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    @Override
    public String toString() {
        String doceStr = doce ? "Doce" : "Light";
        return super.toString() + " - Quantidade: " + quantidade + " - " + doceStr + " - Informação: " + informacao;
    }
}

