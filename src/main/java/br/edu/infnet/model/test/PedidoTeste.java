package br.edu.infnet.model.test;

import br.edu.infnet.model.domain.Produto;
import br.edu.infnet.model.domain.Pedido;
import br.edu.infnet.model.domain.Solicitante;
import br.edu.infnet.model.domain.Bebida;
import br.edu.infnet.model.domain.Comida;
import br.edu.infnet.model.domain.Sobremesa;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoTeste {
    public static void main(String[] args) {
        Solicitante solicitanteMaria = new Solicitante("Maria", "987.654.321-00", "maria@email.com");
        Bebida suco = new Bebida("Suco", 5.0f, 103, true, 300f, "Natural");
        Comida salada = new Comida("Salada", 10.0f, 104, 0.3f, true, "Verduras");
        Sobremesa pudim = new Sobremesa("Pudim", 7.0f, 107, 0.2f, true, "Leite condensado");

        List<Produto> produtosMaria = new ArrayList<>();
        produtosMaria.add(suco);
        produtosMaria.add(salada);
        produtosMaria.add(pudim);

        Pedido pedidoMaria = new Pedido("Almoço", LocalDateTime.now(), true, solicitanteMaria, produtosMaria);
        System.out.println("Pedido Maria: " + pedidoMaria.toString());
        pedidoMaria.imprimirPedido("pedido_maria.txt");

        Solicitante solicitanteJoao = new Solicitante("João", "123.456.789-00", "joao@email.com");
        Bebida cafe = new Bebida("Café", 3.0f, 105, false, 150f, "Expresso");
        Comida sanduiche = new Comida("Sanduíche", 8.0f, 106, 0.2f, false, "Pão, queijo, presunto");
        Sobremesa bolo = new Sobremesa("Bolo", 6.0f, 108, 0.3f, true, "Chocolate");

        List<Produto> produtosJoao = new ArrayList<>();
        produtosJoao.add(cafe);
        produtosJoao.add(sanduiche);
        produtosJoao.add(bolo);

        Pedido pedidoJoao = new Pedido("Lanche", LocalDateTime.now(), false, solicitanteJoao, produtosJoao);
        System.out.println("Pedido João: " + pedidoJoao.toString());
        pedidoJoao.imprimirPedido("pedido_joao.txt");

        Solicitante solicitantePedro = new Solicitante("Pedro", "111.222.333-44", "pedro@email.com");
        Bebida agua = new Bebida("Água", 2.0f, 109, false, 500f, "Mineral");
        Comida arrozFeijao = new Comida("Arroz e Feijão", 12.0f, 110, 0.4f, true, "Arroz, feijão");
        Sobremesa sorvete = new Sobremesa("Sorvete", 5.0f, 111, 0.3f, false, "Morango");

        List<Produto> produtosPedro = new ArrayList<>();
        produtosPedro.add(agua);
        produtosPedro.add(arrozFeijao);
        produtosPedro.add(sorvete);

        Pedido pedidoPedro = new Pedido("Almoço", LocalDateTime.now(), true, solicitantePedro, produtosPedro);
        System.out.println("Pedido Pedro: " + pedidoPedro.toString());
        pedidoPedro.imprimirPedido("pedido_pedro.txt");

    }
}
