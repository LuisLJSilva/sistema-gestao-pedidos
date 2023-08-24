package br.edu.infnet.model.domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Produto {
    private String nome;
    private float valor;
    private int codigo;

    public Produto(String nome, float valor, int codigo) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
    }

    public Produto() {

    }

    public void imprimirProduto(String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("Nome do Produto: " + nome);
            writer.newLine();
            writer.write("Valor: R$" + valor);
            writer.newLine();
            writer.write("Código: " + codigo);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o produto no arquivo: " + e.getMessage());
            throw e;
        }
    }

    public abstract float calcularDesconto();

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nome + " - R$" + valor + " - Código: " + codigo;
    }

}