# Jogo da Forca em Java (POO)

Projeto desenvolvido como parte de um laboratório prático de Programação Orientada a Objetos (POO) em Java. O objetivo principal foi consolidar conceitos de encapsulamento, modelagem de classes, tratamento de exceções customizadas e controle de fluxo interativo via console.

## Tecnologias Utilizadas

* **Java** (JDK 17+)
* **Paradigma Orientado a Objetos (POO)**
* **Arquitetura em Camadas** (Model, Exception, Enums, Main)

## Conceitos Aplicados

* **Encapsulamento e Ocultação de Dados:** Proteção de atributos e regras de negócio internas nas classes `PalavraSecreta` e `JogoForca`.
* **Uso de Enums:** Padronização e controle estrito do estado da partida (`EM_ANDAMENTO`, `VITORIA`, `DERROTA`) por meio da classe `StatusJogo`.
* **Exceções Personalizadas:** Criação e lançamento de exceções customizadas (`LetraJaInformadaException`) para gerenciar entradas inválidas ou repetidas pelo usuário de forma elegante.
* **Estruturas de Dados Avançadas:** Emprego de `HashSet` para o gerenciamento de letras descobertas e listas para o histórico de tentativas.
* **Interatividade via Console:** Validação de entradas do usuário, tratamento de erros de digitação e renderização dinâmica do boneco da forca.

## Estrutura do Projeto

```text
src/
├── enums/
│   └── StatusJogo.java
├── exception/
│   └── LetraJaInformadaException.java
├── model/
│   ├── JogoForca.java
│   └── PalavraSecreta.java
└── main/
    └── Main.java