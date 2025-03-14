package verificarPalindromoV3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Escreva um programa que leia uma sequência de caracteres
 * e indique se a mesma é um palíndromo ou não.
 * Usando Map<Integer, String> e Streams.
*/

public class VerificarPalindromoV3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int qtd = lerInteiroPositivo(entrada);
        Map<Integer, String> frases = lerFrases(qtd, entrada);

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

    public static Map<Integer, String> lerFrases(int qtd, Scanner entrada) {
        return IntStream.rangeClosed(1, qtd)
                .boxed()
                .collect(Collectors.toMap(
                        i -> i, // Chave: número da entrada
                        i -> solicitarValor("Digite a " + i + " frase: ", entrada), // Valor: frase digitada
                        (a, b) -> b, // Caso haja conflito de chave, o último valor é escolhido
                        LinkedHashMap::new)); // Mantém a ordem de inserção
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

    public static void imprimirResultados(Map<Integer, String> frases) {
        System.out.println("\n=== RESULTADOS ===");
        for (Map.Entry<Integer, String> entry : frases.entrySet()) {
            Integer chave = entry.getKey();
            String frase = entry.getValue();
            boolean palindromo = verificarPalindromo(frase);
            System.out.println("Frase " + chave + ": " + frase + " -> "
                    + (palindromo ? "E um palindromo." : "Nao e um palindromo."));
        }
    }

    public static boolean verificarPalindromo(String palavra) {
        String palavraFormatada = palavra.replaceAll("\\s+", "").toLowerCase();
        return new StringBuilder(palavraFormatada).reverse().toString().equals(palavraFormatada);
    }
}
