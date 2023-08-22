package br.edu.infnet.model.domain;

public abstract class Produto {
    private String nome;
    private float valor;
    private int codigo;

    public Produto(String nome, float valor, int codigo) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
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