import java.util.Scanner;

public class PositivoEhMedia {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] numeros = lerNumeros(leitor);
        realizarCalculos(numeros);
        leitor.close();
    }

    private static int[] lerNumeros(Scanner leitor) {
        int[] numeros = new int[10];
        System.out.println("Digite 10 números inteiros, sejam positivos ou negativos");
        System.out.println("Digite 'PARAR' para interromper antes de inserir 10 números.");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i + 1) + "° número: ");
            String entrada = leitor.nextLine();

            if (entrada.equalsIgnoreCase("PARAR")) {
                // Se a entrada for "PARAR", interrompe a leitura e retorna o array atual
                return numeros;
            }

            try {
                int numero = Integer.parseInt(entrada);
                numeros[i] = numero;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                i--; // Decrementa o contador para solicitar novamente o número válido
            }
        }

        return numeros;
    }

    public static void realizarCalculos(int[] numeros) {
        int countPositivos = contarPositivos(numeros);
        int countNegativos = contarNegativos(numeros);
        int somaPositivos = somarPositivos(numeros);
        int somaNegativos = somarNegativos(numeros);

        double mediaPositivos = calcularMedia(somaPositivos, countPositivos);
        double mediaNegativos = calcularMedia(somaNegativos, countNegativos);
        double mediaGeral = calcularMedia(somaPositivos + somaNegativos, numeros.length);

        exibirResultados(countPositivos, countNegativos, mediaPositivos, mediaNegativos, mediaGeral, numeros,
                somaPositivos, somaNegativos);
    }

    public static int contarPositivos(int[] numeros) {
        int countPositivos = 0;
        for (int num : numeros) {
            if (num > 0) {
                countPositivos++;
            }
        }
        return countPositivos;
    }

    public static int contarNegativos(int[] numeros) {
        int countNegativos = 0;
        for (int num : numeros) {
            if (num < 0) {
                countNegativos++;
            }
        }
        return countNegativos;
    }

    public static int somarPositivos(int[] numeros) {
        int somaPositivos = 0;
        for (int num : numeros) {
            if (num > 0) {
                somaPositivos += num;
            }
        }
        return somaPositivos;
    }

    public static int somarNegativos(int[] numeros) {
        int somaNegativos = 0;
        for (int num : numeros) {
            if (num < 0) {
                somaNegativos += num;
            }
        }
        return somaNegativos;
    }

    public static double calcularMedia(int soma, int count) {
        return count > 0 ? (double) soma / count : 0.0;
    }

    private static void exibirResultados(int countPositivos, int countNegativos, double mediaPositivos,
            double mediaNegativos, double mediaGeral, int[] numeros, int somaPositivos, int somaNegativos) {
        System.out.println("A quantidade de números positivos é igual a: " + countPositivos);
        System.out.println("A quantidade de números negativos é igual a: " + countNegativos);
        System.out.println("A média dos valores positivos é igual a: " + mediaPositivos);
        System.out.println("A média dos valores negativos é igual a: " + mediaNegativos);
        System.out.println("A média de todos os números é igual a: " + mediaGeral);

        System.out.print("\n--- Cálculos realizados ---\n");
        System.out.println("Quantidade de números positivos: " + countPositivos);
        System.out.println("Soma dos valores positivos: " + somaPositivos);
        System.out.print("Valores positivos utilizados: ");
        exibirValoresPositivos(numeros);
        System.out.println("Média dos valores positivos: " + mediaPositivos);

        System.out.println();

        System.out.println("Quantidade de números negativos: " + countNegativos);
        System.out.println("Soma dos valores negativos: " + somaNegativos);
        System.out.print("Valores negativos utilizados: ");
        exibirValoresNegativos(numeros);
        System.out.println("Média dos valores negativos: " + mediaNegativos);

        System.out.println();

        System.out.print("Todos os valores utilizados: ");
        exibirTodosValores(numeros);
        System.out.println("Média de todos os números: " + mediaGeral);
    }

    private static void exibirValoresPositivos(int[] numeros) {
        boolean primeiroValor = true;
        for (int num : numeros) {
            if (num > 0) {
                if (!primeiroValor) {
                    System.out.print(", ");
                }
                System.out.print(num);
                primeiroValor = false;
            }
        }
        System.out.println();
    }

    private static void exibirValoresNegativos(int[] numeros) {
        boolean primeiroValor = true;
        for (int num : numeros) {
            if (num < 0) {
                if (!primeiroValor) {
                    System.out.print(", ");
                }
                System.out.print(num);
                primeiroValor = false;
            }
        }
        System.out.println();
    }

    private static void exibirTodosValores(int[] numeros) {
        boolean primeiroValor = true;
        for (int num : numeros) {
            if (!primeiroValor) {
                System.out.print(", ");
            }
            System.out.print(num);
            primeiroValor = false;
        }
        System.out.println();
    }
}
