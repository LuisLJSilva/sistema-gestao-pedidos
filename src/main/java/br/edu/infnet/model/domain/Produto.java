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

    public abstract void metodoAbstrato(); // Método abstrato para ser implementado nas classes filhas

    // Getters e setters

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", codigo=" + codigo +
                '}';
    }
}
