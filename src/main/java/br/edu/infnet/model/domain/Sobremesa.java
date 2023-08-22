package br.edu.infnet.model.domain;

public class Sobremesa extends Produto {
    private float quantidade;
    private boolean doce;
    private String informacao;

    public Sobremesa(String nome, float valor, int codigo, float quantidade, boolean doce, String informacao) {
        super(nome, valor, codigo);
        this.quantidade = quantidade;
        this.doce = doce;
        this.informacao = informacao;
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

