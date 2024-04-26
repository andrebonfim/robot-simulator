# Simulador de Robô - Projeto de Estudo

Este projeto é uma adaptação do simulador de robô criado pelo [professor Jesimar da Silva Arantes](https://github.com/jesimar), desenvolvido e ajustado para fins educacionais na disciplina de Linguagem Orientada a Objetos, parte da graduação de Engenharia de Software no Centro Universitário Anhanguera Pitágoras Ampli.

## Sobre o Projeto

O simulador de robô é uma aplicação Java que utiliza JavaFX para criar uma simulação gráfica de um robô operando em um ambiente de armazém. O projeto permite a interação com o robô através do teclado, controlando seus movimentos e simulando a operação de carregamento de caixas.

### Características Principais

- **Animação em Zigue-Zague:** Implementação de uma animação que simula o movimento de uma máquina carregadora de caixas em operação, criando um cenário mais dinâmico e realista para a simulação.
- **Uso de Threads:** A animação da máquina carregadora opera de forma independente do movimento do robô, graças ao uso de threads, permitindo uma simulação mais complexa e interativa.
- **Controle do Robô:** O robô pode ser controlado através do teclado, permitindo ao usuário mover o robô em diferentes direções e alterar sua velocidade.
- **Integração com Banco de Dados:** O sistema realiza operações de inserção em um banco de dados para registrar as posições do robô, facilitando o acompanhamento de sua trajetória.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação utilizada para desenvolver a lógica da aplicação.
- **JavaFX:** Framework utilizado para criar a interface gráfica do usuário (GUI).
- **MySQL Connector for Java:** Dependência utilizada para conectar a aplicação ao banco de dados MySQL.

## Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Maven, organizado da seguinte forma:

- **src/main/java:** Contém o código-fonte da aplicação, incluindo a lógica de movimentação do robô e da máquina carregadora, além da configuração da interface gráfica.
- **src/main/resources:** Armazena recursos utilizados pela aplicação, como imagens.
- **src/test/java:** Diretório destinado aos códigos de teste da aplicação.

## Como Executar

Para executar o projeto, é necessário ter o JDK instalado em sua máquina, bem como o Maven para gerenciar as dependências. Após clonar o repositório, navegue até o diretório do projeto e execute o seguinte comando no terminal:

```bash
mvn clean javafx:run
```

Este comando compila o projeto e inicia a aplicação, abrindo a interface gráfica do simulador de robô.

## Contribuições

Este projeto foi adaptado e ajustado com o objetivo de servir como material de estudo e prática para a disciplina de Linguagem Orientada a Objetos. Contribuições e sugestões são bem-vindas para aprimorar o projeto e enriquecer o aprendizado.
