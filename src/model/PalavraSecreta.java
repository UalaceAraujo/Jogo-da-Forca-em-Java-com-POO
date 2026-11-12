package model;

import java.util.HashSet;
import java.util.Set;

public class PalavraSecreta {
    private final String palavra;
    private final String dica;
    private final Set<Character> letrasDescobertas;

    public PalavraSecreta(String palavra, String dica) {
        this.palavra = palavra.toUpperCase().trim();
        this.dica = dica;
        this.letrasDescobertas = new HashSet<>();
    }

    public boolean tentarLetra(char letra) {
        letra = Character.toUpperCase(letra);
        if (palavra.indexOf(letra) >= 0) {
            letrasDescobertas.add(letra);
            return true;
        }
        return false;
    }

    public boolean estaCompleta() {
        for (char c : palavra.toCharArray()) {
            if (c != ' ' && !letrasDescobertas.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String getPalavraMascarada() {
        StringBuilder sb = new StringBuilder();
        for (char c : palavra.toCharArray()) {
            if (c == ' ') {
                sb.append("  ");
            } else if (letrasDescobertas.contains(c)) {
                sb.append(c).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString().trim();
    }

    public String getPalavraOriginal() {
        return palavra;
    }

    public String getDica() {
        return dica;
    }
}