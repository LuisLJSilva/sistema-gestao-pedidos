package br.edu.infnet.model.domain;

import br.edu.infnet.model.domain.exceptions.ProdutoInvalidoException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public abstract class Produto {
    private String nome;
    private float valor;
    private int codigo;
    private Set<String> categorias;

    public Produto(String nome, float valor, int codigo, Set<String> categorias) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
        this.categorias = categorias;
    }

    public Produto() {
        this.categorias = new HashSet<>();
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<String> getCategorias() {
        return categorias;
    }
    public void setCategorias(Set<String> categorias) {
        this.categorias = categorias;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) throws ProdutoInvalidoException {
        if (valor <= 0) {
            throw new ProdutoInvalidoException("O valor do produto deve ser maior que zero.");
        }
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return nome + " - R$" + valor + " - Código: " + codigo;
    }
}