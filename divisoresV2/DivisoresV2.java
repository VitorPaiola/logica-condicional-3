package divisoresV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Escreva um programa que solicite ao usuário
 * uma sequência de números e exiba seus divisores.
 * Usando List<Integer>.
*/

public class DivisoresV2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Integer> numeros = lerNumeros(entrada);

        imprimirResultados(numeros);

        entrada.close();
    }

    public static List<Integer> lerNumeros(Scanner entrada) {
        int qtd = solicitarValor("Quantas sequencias de numeros voce deseja inserir? ", entrada);
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            int numero = solicitarValor("Digite o " + (i + 1) + " numero: ", entrada);
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

    public static void imprimirResultados(List<Integer> numeros) {
        for (Integer numero : numeros) {
            System.out.println("Divisores de " + numero + ": " + verificarDivisores(numero));
        }
    }

    public static List<Integer> verificarDivisores(Integer numero) {
        List<Integer> divisores = new ArrayList<>();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores.add(i);
            }
        }
        return divisores;
    }
}
