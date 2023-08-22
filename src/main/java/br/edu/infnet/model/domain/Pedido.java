package br.edu.infnet.model.domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pedido {
    private static final Logger logger = Logger.getLogger(Pedido.class.getName());
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

    public void imprimirPedido(String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
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
                writer.write("  " + produto.toString());
                writer.newLine();
            }
            writer.write("Total do Pedido: " + calcularTotal());
            writer.newLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao imprimir o pedido", e);
        }
    }

    private float calcularTotal() {
        float total = 0;
        for (Produto produto : produtos) {
            total += produto.getValor(); // ou outra lógica para calcular o valor
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
