package mdcProgram;

import java.util.Scanner;

/*
 * Escreva um programa que determine o máximo divisor
 * comum (MDC) entre dois números informados pelo usuário.
 * Usando array.
*/

public class MDCProgram {
    private static final int TAM_LISTA = 2;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = lerNumeros(entrada);
        int mdc = calcularMDC(numeros);

        imprimirResultados(numeros, mdc);

        entrada.close();
    }

    public static int[] lerNumeros(Scanner entrada) {
        String[] variaveis = { "primeiro", "segundo" };
        int[] numeros = new int[TAM_LISTA];

        for (int i = 0; i < TAM_LISTA; i++) {
            numeros[i] = solicitarValor("Digite o " + variaveis[i] + " numero: ", entrada);
        }
        return numeros;
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

    public static int calcularMDC(int[] numeros) {
        int n1 = numeros[0];
        int n2 = numeros[1];

        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }

    public static void imprimirResultados(int[] numeros, int mdc) {
        System.out.println("O MDC entre " + numeros[0] + " e " + numeros[1] + " e: " + mdc);
    }
}
