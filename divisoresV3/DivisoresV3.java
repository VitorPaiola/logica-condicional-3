package divisoresV3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Escreva um programa que solicite ao usuário
 * uma sequência de números e exiba seus divisores.
 * Usando Map<Integer, List<Integer>>.
 */

public class DivisoresV3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Integer> numeros = lerNumeros(entrada);

        Map<Integer, List<Integer>> resultados = calcularDivisores(numeros);

        imprimirResultados(resultados);

        entrada.close();
    }

    public static List<Integer> lerNumeros(Scanner entrada) {
        int qtd = solicitarValor("Quantas sequencias de numeros voce deseja inserir? ", entrada);
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            numeros.add(solicitarValor("Digite o " + (i + 1) + " numero: ", entrada));
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

    public static Map<Integer, List<Integer>> calcularDivisores(List<Integer> numeros) {
        Map<Integer, List<Integer>> divisores = new HashMap<>();

        for (Integer numero : numeros) {
            divisores.put(numero, verificarDivisores(numero));
        }
        return divisores;
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

    public static void imprimirResultados(Map<Integer, List<Integer>> resultados) {
        for (Map.Entry<Integer, List<Integer>> entrada : resultados.entrySet()) {
            System.out.println("Divisores de " + entrada.getKey() + ": " + entrada.getValue());
        }
    }
}


/*
 * **Quando usar cada um?**
 * Use `HashMap` quando a ordem dos elementos não for importante, e o desempenho for uma consideração mais importante, como em casos de grandes volumes de dados ou operações frequentes de inserção e busca, como no cálculo de divisores.
 * 
 * Use `LinkedHashMap` quando for importante manter a ordem de inserção dos elementos, como quando você precisa iterar sobre o mapa na mesma ordem em que os elementos foram adicionados.
 * 
 * **Exemplo em contexto de divisores:**
 * No exemplo de calcular divisores, a ordem das chaves (números) e seus divisores não tem importância para o objetivo do programa (mostrar os divisores). Portanto, um `HashMap` seria uma escolha eficiente, já que ele não precisa garantir a ordem de inserção.
 * 
 * Se, por algum motivo, você precisasse garantir a ordem de inserção, como quando precisar mostrar os divisores na mesma ordem em que os números foram lidos ou inseridos, então `LinkedHashMap` seria a melhor escolha.
 * 
 * Conclusão:
 * Usei `HashMap` porque, neste caso, a ordem dos elementos não é relevante para a lógica do programa. Se você precisar de ordem, pode optar por `LinkedHashMap`, mas geralmente, para desempenho e simplicidade, o `HashMap` é preferido quando a ordem não importa.
*/