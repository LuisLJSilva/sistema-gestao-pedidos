package br.edu.infnet.model.domain;

public class Comida extends Produto {
    private float peso;
    private boolean vegano;
    private String ingredientes;

    public Comida(String nome, float valor, int codigo, float peso, boolean vegano, String ingredientes) {
        super(nome, valor, codigo);
        this.peso = peso;
        this.vegano = vegano;
        this.ingredientes = ingredientes;
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
