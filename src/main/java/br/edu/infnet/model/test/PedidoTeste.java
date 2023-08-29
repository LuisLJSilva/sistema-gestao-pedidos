package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Bebida;
import br.edu.infnet.model.domain.Comida;
import br.edu.infnet.model.domain.Pedido;
import br.edu.infnet.model.domain.Produto;
import br.edu.infnet.model.domain.Sobremesa;
import br.edu.infnet.model.domain.Solicitante;

import br.edu.infnet.model.domain.exceptions.SolicitanteInvalidoException;
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

    public static <T> List<T> lerProdutos(String path, TypeReference<List<T>> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(path).toFile(), type);
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
                writer.write(produto.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws SolicitanteInvalidoException, IOException {
        String resourcesPath = "src/main/resources/";

        List<Bebida> bebidas = lerProdutos(resourcesPath + "bebidas.json", new TypeReference<>() {});
        List<Comida> comidas = lerProdutos(resourcesPath + "comidas.json", new TypeReference<>() {});
        List<Sobremesa> sobremesas = lerProdutos(resourcesPath + "sobremesas.json", new TypeReference<>() {});

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
