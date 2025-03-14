package mmcProgramV3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Faça um programa que determine o
 * menor múltiplo comum (MMC) entre dois
 * números informados pelo usuário.
 * Usando Map<Integer, Integer> e EntrySet
*/

public class MMCProgramV3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Map<Integer, Integer> numeros = lerNumeros(entrada);

        int mdc = calcularMDC(numeros.get(1), numeros.get(2));
        int mmc = Math.abs(numeros.get(1) * numeros.get(2)) / mdc;

        imprimirResultados(numeros, mmc);

        entrada.close();
    }

    public static Map<Integer, Integer> lerNumeros(Scanner entrada) {
        Map<Integer, Integer> numeros = new HashMap<>();
        numeros.put(1, solicitarValor("Digite o primeiro numero: ", entrada));
        numeros.put(2, solicitarValor("Digite o segundo numero: ", entrada));
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
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }

    public static void imprimirResultados(Map<Integer, Integer> numeros, int mmc) {
        for (Map.Entry<Integer, Integer> entry : numeros.entrySet()) {
            if (entry.getKey() == 1) {
                System.out.print("O MMC entre " + entry.getValue() + " e ");
            } else if (entry.getKey() == 2) {
                System.out.println(entry.getValue() + " e: " + mmc);
            }
        }
    }
}
