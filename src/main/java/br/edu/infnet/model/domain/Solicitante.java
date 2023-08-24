package br.edu.infnet.model.domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Solicitante {
    private String nome;
    private String cpf;
    private String email;

    public Solicitante(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public void imprimirSolicitante(String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("CPF: " + cpf);
            writer.newLine();
            writer.write("Email: " + email);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao gravar o solicitante no arquivo: " + e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

