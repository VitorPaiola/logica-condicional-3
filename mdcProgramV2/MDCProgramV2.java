package mdcProgramV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Escreva um programa que determine o máximo divisor
 * comum (MDC) entre dois números informados pelo usuário.
 * Usando List<Integer>.
*/

public class MDCProgramV2 {
    private static final int TAM_LISTA = 2;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Integer> numeros = lerNumeros(entrada);
        int mdc = calcularMDC(numeros);

        imprimirResultados(numeros, mdc);

        entrada.close();
    }

    public static List<Integer> lerNumeros(Scanner entrada) {
        List<String> variaveis = List.of("primeiro", "segundo");
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < TAM_LISTA; i++) {
            int numero = solicitarValor("Digite o " + variaveis.get(i) + " numero: ", entrada);
            numeros.add(numero);
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

    public static int calcularMDC(List<Integer> numeros) {
        int n1 = numeros.get(0);
        int n2 = numeros.get(1);

        while (n2 != 0) { // n1 = 8 e n2 = 6
            int temp = n2; // temp = 6 -> temp = 2 
            n2 = n1 % n2; // n2 = 8 % 6 = 2 -> n2 = 6 % 2 = 0
            n1 = temp; // n1 = 6 -> n1 = 2
        }
        return n1; // Retorna 2
    }

    public static void imprimirResultados(List<Integer> numeros, int mdc) {
        System.out.println("O MDC entre " + numeros.get(0) + " e " + numeros.get(1) + " e: " + mdc);
    }
}
