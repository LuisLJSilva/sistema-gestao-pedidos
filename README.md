# Sobre
Este projeto é um sistema de gerenciamento de pedidos de comida. Ele permite que os usuários lidem com diferentes tipos de produtos (Comida, Bebida, Sobremesa) e gerencia informações sobre pedidos e solicitantes.

## Recursos
- Crie pedidos
- Adicione produtos aos pedidos
- Acompanhe o status de seus pedidos
- Veja o histórico de pedidos

## Classes Principais

### Solicitante

Representa uma pessoa que fez um pedido. Contém informações como nome, CPF e email.

### Produto

Uma classe abstrata que representa um produto genérico. Contém informações como nome, valor e código. Possui um método abstrato para calcular o desconto.

#### Comida, Bebida, Sobremesa

Classes que estendem a classe `Produto`, representando diferentes tipos de produtos. Cada uma tem seus próprios atributos e métodos específicos.

### Pedido

Representa um pedido contendo informações como descrição, data e hora, confirmação pela web, solicitante e lista de produtos.

## Funcionalidades

- **Impressão de informações**: Cada classe possui um método `imprimir` que escreve as informações relevantes em um arquivo.
- **Cálculo de desconto**: Cada tipo de produto possui sua própria lógica para calcular o desconto.
- **Gerenciamento de pedidos**: A classe `Pedido` gerencia uma lista de produtos e é capaz de calcular o total do pedido.

## Como Utilizar

1. Instancie os objetos de produtos e solicitantes de acordo com suas necessidades.
2. Crie um objeto `Pedido`, adicionando os produtos e o solicitante.
3. Chame o método `imprimirPedido` para gravar os detalhes do pedido em um arquivo.

## Dependências

- Jackson Annotations para mapeamento de propriedades JSON.

Obrigado por usar nosso sistema!