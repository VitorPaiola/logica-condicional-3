package verificarPalindromo;

import java.util.Scanner;

/*
 * Escreva umm programa que leia uma sequência de caracteres
 * e indique se a mesma é um palíndromo ou não.
 * Usando array.
*/

public class VerificarPalindromo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int quantidade = lerInteiroPositivo(entrada);

        String[] frases = new String[quantidade];

        lerFrases(quantidade, entrada, frases);

        imprimirResultados(frases);

        entrada.close();
    }

    public static int lerInteiroPositivo(Scanner entrada) {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Quantas sequencias de caracteres voce deseja inserir? ");
            String input = entrada.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Entrada vazia nao permitida. Digite um numero maior que zero.");
                continue;
            }

            try {
                numero = Integer.parseInt(input);
                if (numero > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Entrada invalida. Digite um numero maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite apenas numeros.");
            }
        }
        return numero;
    }

    public static void lerFrases(int quantidade, Scanner entrada, String[] frases) {
        for (int i = 0; i < quantidade; i++) {
            frases[i] = solicitarValor("Digite a " + (i + 1) + " frase: ", entrada);
        }
    }

    public static void imprimirResultados(String[] frases) {
        System.out.println("\n=== RESULTADOS ===");
        for (String palavra : frases) {
            if (verificarPalindromo(palavra)) {
                System.out.println("\"" + palavra + "\" e um palindromo.");
            } else {
                System.out.println("\"" + palavra + "\" nao e um palindromo.");
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
        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarPalindromo(String palavra) {
        String palavraFormatada = palavra.replaceAll("\\s+", "").toLowerCase();
        int esquerda = 0, direita = palavraFormatada.length() - 1;

        while (esquerda < direita) {
            if (palavraFormatada.charAt(esquerda) != palavraFormatada.charAt(direita)) {
                return false;
            }
            esquerda++;
            direita--;
        }
        return true;
    }
}
