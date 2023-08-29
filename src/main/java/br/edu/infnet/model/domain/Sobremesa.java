package br.edu.infnet.model.domain;

import br.edu.infnet.model.domain.exceptions.SobremesaInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Sobremesa extends Produto {
    private float quantidade;
    private boolean doce;
    @JsonProperty("informacao")
    private String informacao;

    public Sobremesa() {
    }

    @JsonCreator
    public Sobremesa(
            @JsonProperty("nome") String nome,
            @JsonProperty("valor") float valor,
            @JsonProperty("codigo") int codigo,
            @JsonProperty("quantidade") float quantidade,
            @JsonProperty("doce") boolean doce,
            @JsonProperty("informacao") String informacao,
            @JsonProperty("categorias") Set<String> categorias
    ) throws SobremesaInvalidaException {
        super(nome, valor, codigo, categorias);

        if (quantidade <= 0) {
            throw new SobremesaInvalidaException("A quantidade da sobremesa deve ser maior que zero.");
        }
        this.quantidade = quantidade;

        this.doce = doce;
        this.informacao = informacao;
    }

    @Override
    public float calcularDesconto() {
        return doce ? getValor() * 0.05f : 0;
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
