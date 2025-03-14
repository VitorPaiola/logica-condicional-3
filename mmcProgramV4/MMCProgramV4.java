package mmcProgramV4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Faça um programa que determine o
 * menor múltiplo comum (MMC) entre uma
 * quantidade de verificações e números 
 * informados pelo usuário.
 * Usando Map<Integer, List<Integer>> e EntrySet
*/

public class MMCProgramV4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int qtdVerificacoes = obterQtdVerificacoes(entrada);
        Map<Integer, List<Integer>> verificacoes = obterVerificacoes(entrada, qtdVerificacoes);

        exibirResultados(verificacoes);

        entrada.close();
    }

    // Obtém a quantidade de verificações
    private static int obterQtdVerificacoes(Scanner entrada) {
        return solicitarValor("Quantas verificacoes de MMC voce deseja fazer? ", entrada);
    }

    private static int solicitarValor(String mensagem, Scanner entrada) {
        int numero;
        while (true) {
            System.out.print(mensagem);
            String input = entrada.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Entrada vazia nao permitida. Digite apenas numeros maiores que zero.");
                continue;
            }

            try {
                numero = Integer.parseInt(input);
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Entrada invalida. Digite apenas numeros maiores que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite apenas numeros.");
            }
        }
    }

    // Coleta os números para as verificações
    private static Map<Integer, List<Integer>> obterVerificacoes(Scanner entrada, int qtdVerificacoes) {
        Map<Integer, List<Integer>> verificacoes = new HashMap<>();

        for (int i = 1; i <= qtdVerificacoes; i++) {
            int qtdNumeros = obterQtdNumeros(entrada, i);
            List<Integer> numeros = lerNumeros(entrada, qtdNumeros);
            verificacoes.put(i, numeros);
        }
        return verificacoes;
    }

    // Obtém a quantidade de números para cada verificação
    private static int obterQtdNumeros(Scanner entrada, int verificacaoId) {
        return solicitarValor("Quantos numeros voce deseja inserir para a verificacao " + verificacaoId + "? ",
                entrada);
    }

    // Lê os números inseridos pelo usuário
    private static List<Integer> lerNumeros(Scanner entrada, int qtdNumeros) {
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < qtdNumeros; i++) {
            while (true) {
                System.out.print("Digite o " + (i + 1) + " numero: ");
                String input = entrada.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Entrada vazia nao permitida. Digite apenas numeros maiores que zero.");
                    continue;
                }

                try {
                    int numero = Integer.parseInt(input);
                    if (numero > 0) {
                        numeros.add(numero);
                        break;
                    } else {
                        System.out.println("Entrada invalida. Digite apenas numeros maiores que zero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida. Digite apenas numeros.");
                }
            }
        }
        return numeros;
    }

    // Exibe os resultados para todas as verificações
    private static void exibirResultados(Map<Integer, List<Integer>> verificacoes) {
        System.out.println();
        for (Map.Entry<Integer, List<Integer>> entry : verificacoes.entrySet()) {
            int verificacaoId = entry.getKey();
            List<Integer> numeros = entry.getValue();
            int mmc = calcularMMC(numeros);
            System.out.println("Verificacao " + verificacaoId + ": O MMC entre " + numeros + " e: " + mmc);
        }
    }

    // Método para calcular o MDC
    public static int calcularMDC(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }

    // Método para calcular o MMC a partir de uma lista de números
    public static int calcularMMC(List<Integer> numeros) {
        int mmc = numeros.get(0); // Começa com o primeiro número da lista
        for (int i = 1; i < numeros.size(); i++) {
            mmc = (mmc * numeros.get(i)) / calcularMDC(mmc, numeros.get(i));
        }
        return mmc;
    }
}
