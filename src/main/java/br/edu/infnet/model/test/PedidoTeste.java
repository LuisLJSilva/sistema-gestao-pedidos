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

    public static <Bebida> List<Bebida> lerBebidas(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Bebida> bebidas = objectMapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Bebida>>() {});
        return bebidas;
    }

    public static List<Comida> lerComidas(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Comida> comidas = objectMapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Comida>>() {});
        return comidas;
    }

    public static List<Sobremesa> lerSobremesas(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Sobremesa> sobremesas = objectMapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Sobremesa>>() {});
        return sobremesas;
    }


    public static void main(String[] args) throws IOException {
        String resourcesPath = "src/main/resources/";

        ObjectMapper objectMapper = new ObjectMapper();

        List<Bebida> bebidas = objectMapper.readValue(Paths.get(resourcesPath + "bebidas.json").toFile(), new TypeReference<List<Bebida>>() {});
        List<Comida> comidas = objectMapper.readValue(Paths.get(resourcesPath + "comidas.json").toFile(), new TypeReference<List<Comida>>() {});
        List<Sobremesa> sobremesas = objectMapper.readValue(Paths.get(resourcesPath + "sobremesas.json").toFile(), new TypeReference<List<Sobremesa>>() {});

        try {
            bebidas = lerBebidas(resourcesPath +"bebidas.json");
            comidas = lerComidas(resourcesPath+ "comidas.json");
            sobremesas = lerSobremesas(resourcesPath+ "sobremesas.json");
        } catch (IOException e) {
            System.err.println("Erro ao ler os arquivos JSON: " + e.getMessage());
        }

        Solicitante solicitanteJoao = new Solicitante("João", "123.456.789-00", "joao@email.com");
        List<Produto> produtosJoao = new ArrayList<>();
        produtosJoao.add(bebidas.get(0));
        produtosJoao.add(comidas.get(1));
        produtosJoao.add(sobremesas.get(2));
        Pedido pedidoJoao = new Pedido("Lanche", LocalDateTime.now(), false, solicitanteJoao, produtosJoao);

        Solicitante solicitanteMaria = new Solicitante("Maria", "321.654.987-00", "maria@email.com");
        List<Produto> produtosMaria = new ArrayList<>();
        produtosMaria.add(bebidas.get(1));
        produtosMaria.add(comidas.get(0));
        produtosMaria.add(sobremesas.get(1));
        Pedido pedidoMaria = new Pedido("Almoço", LocalDateTime.now(), true, solicitanteMaria, produtosMaria);

        Solicitante solicitantePedro = new Solicitante("Pedro", "111.222.333-44", "pedro@email.com");
        List<Produto> produtosPedro = new ArrayList<>();
        produtosPedro.add(bebidas.get(0));
        produtosPedro.add(comidas.get(1));
        produtosPedro.add(sobremesas.get(2));
        Pedido pedidoPedro = new Pedido("Almoço", LocalDateTime.now(), false, solicitantePedro, produtosPedro);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedido_efetuado_joao.txt"))) {
            writer.write("Pedido João:");
            writer.newLine();
            writer.write("Descrição do Pedido: " + pedidoJoao.getDescricao());
            writer.newLine();
            writer.write("Data e Hora: " + pedidoJoao.getData());
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo com layout diferente: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedido_efetuado_maria.txt"))) {
            writer.write("Pedido Maria:");
            writer.newLine();
            writer.write("Descrição do Pedido: " + pedidoMaria.getDescricao());
            writer.newLine();
            writer.write("Data e Hora: " + pedidoMaria.getData());
            // Continuar escrevendo as informações conforme necessário
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo com layout diferente: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedido_efetuado_pedro.txt"))) {
            writer.write("Pedido Pedro:");
            writer.newLine();
            writer.write("Descrição do Pedido: " + pedidoPedro.getDescricao());
            writer.newLine();
            writer.write("Data e Hora: " + pedidoPedro.getData());
            // Continuar escrevendo as informações conforme necessário
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo com layout diferente: " + e.getMessage());
        }
    }
}
