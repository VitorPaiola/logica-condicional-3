package validacaoCPF;

import java.util.Scanner;

/*
 * Faça um programa que solicite o CPF do usuário
 * e então faça a validação do mesmo.
*/

public class ValidacaoCPF {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String cpf = lerCPF(entrada);

        if (validarCPF(cpf)) {
            System.out.println("CPF valido!");
        } else {
            System.out.println("CPF invalido!");
        }

        entrada.close();
    }

    // Função para ler o CPF
    public static String lerCPF(Scanner entrada) {
        return solicitarValor("Digite o CPF (somente numeros): ", entrada);
    }

    // Função para solicitar o valor ao usuário
    public static String solicitarValor(String mensagem, Scanner entrada) {
        String cpf;
        while (true) {
            System.out.print(mensagem);
            cpf = entrada.nextLine().trim();

            if (cpf.isEmpty() || cpf.length() != 11) {
                System.out.println("Entrada invalida. O CPF deve ter exatamente 11 digitos.");
                continue;
            }

            if (!cpf.matches("[0-9]+")) {
                System.out.println("Entrada invalida. Digite apenas numeros.");
                continue;
            }

            return cpf;
        }
    }

    // Função para validar o CPF
    public static boolean validarCPF(String cpf) {
        // Verificar se o CPF é composto apenas por números repetidos
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        // Comparar os dígitos verificadores calculados com os do CPF
        return cpf.charAt(9) == (char) ('0' + primeiroDigito) && cpf.charAt(10) == (char) ('0' + segundoDigito);
    }
}
