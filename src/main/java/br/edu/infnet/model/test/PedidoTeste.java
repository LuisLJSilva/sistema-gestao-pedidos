package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Bebida;
import br.edu.infnet.model.domain.Comida;
import br.edu.infnet.model.domain.Pedido;
import br.edu.infnet.model.domain.Produto;
import br.edu.infnet.model.domain.Sobremesa;
import br.edu.infnet.model.domain.Solicitante;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoTeste {

    public static List<Bebida> lerBebidas(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Bebida>>() {});
    }

    public static List<Comida> lerComidas(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Comida>>() {});
    }

    public static List<Sobremesa> lerSobremesas(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Sobremesa>>() {});
    }

    public static void escreverPedido(String fileName, Pedido pedido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Pedido " + pedido.getSolicitante().getNome() + ":");
            writer.newLine();
            writer.write("Descrição do Pedido: " + pedido.getDescricao());
            writer.newLine();
            writer.write("Data e Hora: " + pedido.getData());
            writer.newLine();
            writer.write("Confirmado: " + (pedido.isWeb() ? "Sim" : "Não"));
            writer.newLine();
            writer.write("Solicitante: Nome: " + pedido.getSolicitante().getNome() + ", CPF: " + pedido.getSolicitante().getCpf() + ", Email: " + pedido.getSolicitante().getEmail());
            writer.newLine();
            writer.write("Produtos:");
            writer.newLine();
            for (Produto produto : pedido.getProdutos()) {
                writer.write("Nome: " + produto.getNome() + ", Valor: R$" + produto.getValor() + ", Código: " + produto.getCodigo());
                if (produto instanceof Bebida) {
                    writer.write(", Gelada: " + (((Bebida) produto).isGelada() ? "Sim" : "Não") + ", Tamanho: " + ((Bebida) produto).getTamanho() + ", Marca: " + ((Bebida) produto).getMarca());
                } else if (produto instanceof Comida) {
                    writer.write(", Peso: " + ((Comida) produto).getPeso() + "g" + ", Vegano: " + (((Comida) produto).isVegano() ? "Sim" : "Não") + ", Ingredientes: " + ((Comida) produto).getIngredientes());
                } else if (produto instanceof Sobremesa) {
                    writer.write(", Quantidade: " + ((Sobremesa) produto).getQuantidade() + "g" + ", Doce: " + (((Sobremesa) produto).isDoce() ? "Sim" : "Não") + ", Informação: " + ((Sobremesa) produto).getInformacao());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo com layout diferente: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        String resourcesPath = "src/main/resources/";

        List<Bebida> bebidas = lerBebidas(resourcesPath + "bebidas.json");
        List<Comida> comidas = lerComidas(resourcesPath + "comidas.json");
        List<Sobremesa> sobremesas = lerSobremesas(resourcesPath + "sobremesas.json");

        Solicitante solicitanteJoao = new Solicitante("João", "123.456.789-00", "joao@email.com");
        Solicitante solicitanteMaria = new Solicitante("Maria", "321.654.987-00", "maria@email.com");
        Solicitante solicitantePedro = new Solicitante("Pedro", "111.222.333-44", "pedro@email.com");

        List<Produto> produtosJoao = new ArrayList<>();
        produtosJoao.add(bebidas.get(0));
        produtosJoao.add(comidas.get(1));
        produtosJoao.add(sobremesas.get(2));
        Pedido pedidoJoao = new Pedido("Lanche", LocalDateTime.now(), false, solicitanteJoao, produtosJoao);

        List<Produto> produtosMaria = new ArrayList<>();
        produtosMaria.add(bebidas.get(1));
        produtosMaria.add(comidas.get(0));
        produtosMaria.add(sobremesas.get(1));
        Pedido pedidoMaria = new Pedido("Almoço", LocalDateTime.now(), true, solicitanteMaria, produtosMaria);

        List<Produto> produtosPedro = new ArrayList<>();
        produtosPedro.add(bebidas.get(0));
        produtosPedro.add(comidas.get(1));
        produtosPedro.add(sobremesas.get(2));
        Pedido pedidoPedro = new Pedido("Almoço", LocalDateTime.now(), false, solicitantePedro, produtosPedro);

        escreverPedido(resourcesPath + "pedido_efetuado_joao.txt", pedidoJoao);
        escreverPedido(resourcesPath + "pedido_efetuado_maria.txt", pedidoMaria);
        escreverPedido(resourcesPath + "pedido_efetuado_pedro.txt", pedidoPedro);
    }
}
