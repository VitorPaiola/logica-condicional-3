package mmcProgram;

import java.util.Scanner;

/*
 * Faça um programa que determine o
 * menor múltiplo comum (MMC) entre dois
 * números informados pelo usuário.
 * Usando array.
*/

public class MMCProgram {
    private static final int TAM_LISTA = 2;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = lerNumeros(entrada);

        calcularMMC(numeros);

        imprimirResultados(numeros);

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

    public static int calcularMDC(int n1, int n2) {
        while (n2 != 0) { // n1 = 6 e n2 = 8
            int temp = n2; // temp = 8 -> temp = 6 -> temp = 2
            n2 = n1 % n2; // n2 = 6 % 8 = 6 -> n2 = 8 % 6 = 2 -> n2 = 6 % 2 = 0 <- Fim while
            n1 = temp; // n1 = 8 -> n1 = 6 -> n1 = 2 <- MDC entre 6 e 8 = 2
        }
        return n1; // Retorna 2
    }

    public static int calcularMMC(int[] numeros) {
        int n1 = numeros[0];
        int n2 = numeros[1];
        int mdc = calcularMDC(n1, n2); // 6 e 8
        return Math.abs(n1 * n2) / mdc; // (|6 * 8|) / 2 = 24 <- MMC
    }

    public static void imprimirResultados(int[] numeros) {
        System.out.println("O MMC entre " + numeros[0] + " e " + numeros[1] + " e: " + calcularMMC(numeros));
    }
}
