package main;

import enums.StatusJogo;
import model.JogoForca;
import model.PalavraSecreta;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PalavraSecreta> bancoPalavras = List.of(
            new PalavraSecreta("POLIMORFISMO", "Pilar da Orientação a Objetos"),
            new PalavraSecreta("ENCAPSULAMENTO", "Proteção de dados e atributos de uma classe"),
            new PalavraSecreta("SPRINGBOOT", "Framework Java muito usado em microsserviços"),
            new PalavraSecreta("EXCECAO", "Evento que interrompe o fluxo normal do programa")
        );

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== JOGO DA FORCA - JAVA POO ===");
            System.out.println("1 - Novo Jogo (Palavra Aleatória)");
            System.out.println("2 - Novo Jogo (Definir Palavra Manualmente)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                PalavraSecreta palavraSelecionada = null;

                if (opcao == 1) {
                    palavraSelecionada = bancoPalavras.get(new Random().nextInt(bancoPalavras.size()));
                } else if (opcao == 2) {
                    System.out.print("Digite a palavra secreta: ");
                    String palavra = scanner.nextLine();
                    System.out.print("Digite uma dica: ");
                    String dica = scanner.nextLine();
                    palavraSelecionada = new PalavraSecreta(palavra, dica);
                } else if (opcao == 0) {
                    System.out.println("Encerrando o jogo...");
                    break;
                } else {
                    System.out.println("Opção inválida!");
                    continue;
                }

                iniciarPartida(scanner, new JogoForca(palavraSelecionada));

            } catch (NumberFormatException e) {
                System.out.println("[ERRO]: Digite apenas números para navegar no menu.");
            }
        }
        scanner.close();
    }

    private static void iniciarPartida(Scanner scanner, JogoForca jogo) {
        while (jogo.getStatus() == StatusJogo.EM_ANDAMENTO) {
            jogo.exibirTabuleiro();
            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.isEmpty()) continue;

            try {
                jogo.jogarLetra(entrada.charAt(0));
            } catch (Exception e) {
                System.out.println("\n[AVISO]: " + e.getMessage());
            }
        }

        jogo.exibirTabuleiro();
        if (jogo.getStatus() == StatusJogo.VITORIA) {
            System.out.println("PARABÉNS! Você descobriu a palavra: " + jogo.revelarPalavra());
        } else {
            System.out.println("FIM DE JOGO! Você foi enforcado. A palavra era: " + jogo.revelarPalavra());
        }
    }
}