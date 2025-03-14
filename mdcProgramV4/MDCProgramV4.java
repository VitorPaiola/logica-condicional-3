package mdcProgramV4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Faça um programa que determine o
 * máximo divisor comum (MDC) entre dois
 * números informados pelo usuário.
 * Usando Map<Integer, List<Integer>> e EntrySet
*/

public class MDCProgramV4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int quantidadeDeVerificacoes = obterQuantidadeDeVerificacoes(entrada);
        Map<Integer, List<Integer>> verificacoes = obterVerificacoes(entrada, quantidadeDeVerificacoes);

        imprimirResultados(verificacoes);

        entrada.close();
    }

    private static int obterQuantidadeDeVerificacoes(Scanner entrada) {
        return solicitarValor("\nQuantas verificacoes de MDC voce deseja fazer? ", entrada);
    }

    private static int solicitarValor(String mensagem, Scanner entrada) {
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

    private static Map<Integer, List<Integer>> obterVerificacoes(Scanner entrada, int quantidadeDeVerificacoes) {
        Map<Integer, List<Integer>> verificacoes = new LinkedHashMap<>();

        for (int i = 1; i <= quantidadeDeVerificacoes; i++) {
            int quantidadeDeNumeros = obterQuantidadeDeNumeros(entrada, i);
            List<Integer> numeros = lerNumeros(entrada, quantidadeDeNumeros);
            verificacoes.put(i, numeros);
        }
        return verificacoes;
    }

    private static int obterQuantidadeDeNumeros(Scanner entrada, int verificacaoId) {
        return solicitarValor("\nQuantos numeros voce deseja inserir para a verificacao " + verificacaoId + "? ", entrada);
    }

    private static List<Integer> lerNumeros(Scanner entrada, int quantidadeDeNumeros) {
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < quantidadeDeNumeros; i++) {
            while (true) {
                System.out.print("Digite o " + (i + 1) + " numero: ");
                String input = entrada.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Entrada vazia nao permitida. Digite um numero maior que zero.");
                    continue;
                }

                try {
                    int numero = Integer.parseInt(input);
                    if (numero > 0) {
                        numeros.add(numero);
                        break;
                    } else {
                        System.out.println("Entrada invalida. Digite um numero maior que zero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida. Digite apenas numeros.");
                }
            }
        }
        return numeros;
    }

    public static void imprimirResultados(Map<Integer, List<Integer>> verificacoes) {
        System.out.println();
        for (Map.Entry<Integer, List<Integer>> entry : verificacoes.entrySet()) {
            int verificacaoId = entry.getKey();
            List<Integer> numeros = entry.getValue();
            int mdc = calcularMDC(numeros);
            System.out.println("Verificacao " + verificacaoId + ": O MDC entre " + numeros + " e: " + mdc);
        }
    }

    public static int calcularMDC(List<Integer> numeros) {
        int n1 = numeros.get(0);
        int n2 = numeros.get(1);

        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}
