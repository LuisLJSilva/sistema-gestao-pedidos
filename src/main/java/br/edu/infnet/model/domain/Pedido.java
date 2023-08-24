package br.edu.infnet.model.domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pedido {
    private String descricao;
    private LocalDateTime data;
    private boolean web;
    private Solicitante solicitante;
    private List<Produto> produtos;

    public Pedido(String descricao, LocalDateTime dataHora, boolean confirmado, Solicitante solicitante, List<Produto> produtos) {
        this.descricao = descricao;
        this.data = dataHora;
        this.web = confirmado;
        this.solicitante = solicitante;
        this.produtos = produtos;
    }

    public void imprimirPedido(String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("Descrição do Pedido: " + descricao);
            writer.newLine();
            writer.write("Data e Hora: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            writer.newLine();
            writer.write("Confirmado: " + (web ? "Sim" : "Não"));
            writer.newLine();
            writer.write("Solicitante: " + solicitante.getNome());
            writer.newLine();
            writer.write("Produtos:");
            writer.newLine();
            for (Produto produto : produtos) {
                writer.write("  " + produto.toString() + " - Desconto: R$" + produto.calcularDesconto());
                writer.newLine();
            }
            writer.write("Total do Pedido: " + calcularTotal());
        } catch (IOException e) {
            System.err.println("Erro ao gravar o pedido no arquivo: " + e.getMessage());
        }
    }


    public float calcularTotal() {
        float total = 0;
        for (Produto produto : produtos) {
            total += produto.getValor() - produto.calcularDesconto();
        }
        return total;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "descricao='" + descricao + '\'' +
                ", dataHora=" + data +
                ", confirmado=" + web +
                ", solicitante=" + solicitante +
                ", produtos=" + produtos +
                '}';
    }


}
