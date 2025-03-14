package verificarPalindromoV4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Escreva um programa que leia uma sequência de caracteres
 * e indique se a mesma é um palíndromo ou não.
 * Usando Map<Integer, List<String>> e Streams.
*/

public class VerificarPalindromoV4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Map<Integer, List<String>> frases = lerFrases(entrada);

        imprimirResultados(frases);

        entrada.close();
    }

    public static Map<Integer, List<String>> lerFrases(Scanner entrada) {
        int qtd = solicitarValorInteiro("Quantas sequencias de caracteres voce deseja inserir? ", entrada);
        Map<Integer, List<String>> frases = new HashMap<>();
        for (int i = 1; i <= qtd; i++) {
            List<String> listaFrases = new ArrayList<>();
            int qtdFrasesPorEntrada = solicitarValorInteiro("Quantas frases deseja inserir para a chave " + i + "? ",
                    entrada);
            for (int j = 0; j < qtdFrasesPorEntrada; j++) {
                listaFrases.add(solicitarValor("Digite a " + (j + 1) + " frase: ", entrada));
            }
            frases.put(i, listaFrases);
        }
        return frases;
    }

    public static int solicitarValorInteiro(String mensagem, Scanner entrada) {
        int numero;
        while (true) {
            System.out.print(mensagem);
            String input = entrada.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Entrada vazia nao permitida. Digite um numero maior que zero.");
                continue;
            }

            try {
                numero = Integer.parseInt(input);
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Entrada invalida. Digite um numero maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite apenas numeros.");
            }
        }
    }

    public static String solicitarValor(String mensagem, Scanner entrada) {
        String palavra;
        while (true) {
            System.out.print(mensagem);
            palavra = entrada.nextLine().trim();

            if (palavra.isEmpty()) {
                System.out.println("Entrada vazia nao permitida. Digite uma frase valida.");
            } else if (validarEntrada(palavra)) {
                return palavra;
            } else {
                System.out.println("Entrada invalida. Digite apenas letras, sem numeros ou caracteres especiais.");
            }
        }
    }

    public static boolean validarEntrada(String palavra) {
        return palavra.chars().allMatch(c -> Character.isLetter(c) || Character.isSpaceChar(c));
    }

    public static void imprimirResultados(Map<Integer, List<String>> frases) {
        System.out.println("\n=== RESULTADOS ===");
        for (Map.Entry<Integer, List<String>> entry : frases.entrySet()) {
            Integer chave = entry.getKey();
            List<String> listaFrases = entry.getValue();
            for (String frase : listaFrases) {
                boolean palindromo = verificarPalindromo(frase);
                System.out.println("Frase: " + chave + ": " + frase + " -> "
                        + (palindromo ? "E um palindromo." : "Nao e um palindromo."));
            }
        }
    }

    public static boolean verificarPalindromo(String palavra) {
        String palavraFormatada = palavra.replaceAll("\\s+", "").toLowerCase();
        return new StringBuilder(palavraFormatada).reverse().toString().equals(palavraFormatada);
    }
}
