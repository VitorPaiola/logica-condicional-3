package validarCPF;

import java.util.Scanner;

public class ValidarCPF {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o CPF (somente numeros): ");
        String cpf = entrada.nextLine();
        entrada.close(); // Fecha o Scanner para evitar vazamento de recurso

        cpf = cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos

        if (!validarCPF(cpf)) {
            System.out.println("CPF invalido!");
        } else {
            System.out.println("CPF valido!");
        }
    }

    public static boolean validarCPF(String cpf) {
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false; // Verifica se o CPF tem 11 dígitos e não é uma sequência repetida
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigito = (resto < 2) ? 0 : 11 - resto; // Regra correta

        if ((cpf.charAt(9) - '0') != primeiroDigito) {
            return false;
        }

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = soma % 11;
        int segundoDigito = (resto < 2) ? 0 : 11 - resto; // Regra correta

        return (cpf.charAt(10) - '0') == segundoDigito;
    }
}
