package divisores;

import java.util.Scanner;

/*
 * Escreva um programa que solicite ao usuário
 * uma sequência de números e exiba seus divisores.
 * Usando array.
*/

public class Divisores {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int qtd = solicitarValor("Quantos sequencias de numeros voce deseja inserir? ", entrada);

        Integer[] numeros = new Integer[qtd];

        lerNumeros(qtd, entrada, numeros);

        imprimirResultados(numeros);

        entrada.close();
    }

    public static void lerNumeros(int qtd, Scanner entrada, Integer[] numeros) {
        for (int i = 0; i < qtd; i++) {
            numeros[i] = solicitarValor("Digite o " + (i + 1) + " numero: ", entrada);
        }
    }

    public static int solicitarValor(String mensagem, Scanner entrada) {
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

    public static void imprimirResultados(Integer[] numeros) {
        for (Integer numero : numeros) {
            System.out.print("Divisores de " + numero + ": ");
            verificarDivisores(numero);
        }
    }

    public static void verificarDivisores(Integer numero) {
        String resultado = "[";
        for (int i = 1; i <= numero; i++) {
            resultado += (numero % i == 0) ? i + ", " : "";
        }
        // Remove a última vírgula e fecha colchetes
        resultado = resultado.substring(0, resultado.length() - 2) + "]";
        System.out.println(resultado);
    }
}
