package verificarPalindromoV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Escreva umm programa que leia uma sequência de caracteres
 * e indique se a mesma é um palíndromo ou não.
 * Usando List<String>.
*/

public class VerificarPalindromoV2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int qtd = lerInteiroPositivo(entrada);
        List<String> frases = lerFrases(qtd, entrada);

        imprimirResultados(frases);

        entrada.close();
    }

    public static int lerInteiroPositivo(Scanner entrada) {
        int numero;
        while (true) {
            System.out.print("Quantas sequencias de caracteres voce deseja inserir? ");
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

    public static List<String> lerFrases(int qtd, Scanner entrada) {
        List<String> frases = new ArrayList<>();
        for (int i = 1; i <= qtd; i++) {
            String frase = solicitarValor("Digite a " + i + " frase: ", entrada);
            frases.add(frase);
        }
        return frases;
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

    public static void imprimirResultados(List<String> frases) {
        System.out.println("\n=== RESULTADOS ===");
        for (String frase : frases) {
            System.out.println("\"" + frase + "\" -> " + (verificarPalindromo(frase) ? "E um palindromo." : "Nao e um palindromo."));
        }
    }

    public static boolean verificarPalindromo(String palavra) {
        String palavraFormatada = palavra.replaceAll("\\s+", "").toLowerCase();
        return new StringBuilder(palavraFormatada).reverse().toString().equals(palavraFormatada);
    }
}
