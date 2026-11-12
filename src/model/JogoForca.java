package model;

import enums.StatusJogo;
import exception.LetraJaInformadaException;
import java.util.ArrayList;
import java.util.List;

public class JogoForca {
    private final PalavraSecreta palavraSecreta;
    private final List<Character> letrasTentadas;
    private int erros;
    private final int maxErros = 6;
    private StatusJogo status;

    public JogoForca(PalavraSecreta palavraSecreta) {
        this.palavraSecreta = palavraSecreta;
        this.letrasTentadas = new ArrayList<>();
        this.erros = 0;
        this.status = StatusJogo.EM_ANDAMENTO;
    }

    public void jogarLetra(char letra) {
        if (status != StatusJogo.EM_ANDAMENTO) return;

        letra = Character.toUpperCase(letra);
        if (!Character.isLetter(letra)) {
            throw new IllegalArgumentException("Por favor, digite apenas letras válidas.");
        }
        if (letrasTentadas.contains(letra)) {
            throw new LetraJaInformadaException("A letra '" + letra + "' já foi utilizada.");
        }

        letrasTentadas.add(letra);

        if (!palavraSecreta.tentarLetra(letra)) {
            erros++;
        }

        atualizarStatus();
    }

    private void atualizarStatus() {
        if (palavraSecreta.estaCompleta()) {
            status = StatusJogo.VITORIA;
        } else if (erros >= maxErros) {
            status = StatusJogo.DERROTA;
        }
    }

    public void exibirTabuleiro() {
        System.out.println("\n==========================================");
        System.out.println("DICA: " + palavraSecreta.getDica());
        desenharForca();
        System.out.println("\nPalavra: " + palavraSecreta.getPalavraMascarada());
        System.out.println("Tentativas restantes: " + (maxErros - erros));
        System.out.println("Letras tentadas: " + letrasTentadas);
        System.out.println("==========================================");
    }

    private void desenharForca() {
        System.out.println("  +---+");
        System.out.println("  |   |");
        System.out.println("  |   " + (erros >= 1 ? "O" : ""));
        System.out.println("  |  " + (erros >= 3 ? "/" : " ") + (erros >= 2 ? "|" : "") + (erros >= 4 ? "\\" : ""));
        System.out.println("  |  " + (erros >= 5 ? "/ " : " ") + (erros >= 6 ? "\\" : ""));
        System.out.println("  |");
        System.out.println("=========");
    }

    public StatusJogo getStatus() {
        return status;
    }

    public String revelarPalavra() {
        return palavraSecreta.getPalavraOriginal();
    }
}