package fibonnaci;

import java.util.Scanner;

import fibonnaci.exception.FibonnaciException;

public class FibonnaciLinear {

    public static void main(String[] args) {
        app();
    }

    public static void app() {

        //Tratamento de exceção: Verificar se número recebido não é negativo
        try {

            int numero = digitaNumero();
            validaNumero(numero);

            int resultadoLinear = geraFibonnaciLinear(numero);
            System.out.println("Resultado da sequência de Fibonnaci, feita de maneira *Linear* é: " + resultadoLinear);

        } catch (FibonnaciException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int digitaNumero() {

        Scanner s = new Scanner(System.in);
        System.out.println("Digite um número não negativo: ");
        int numero = s.nextInt();
        s.close();

        return numero;
    }

    public static void validaNumero(int numero) throws FibonnaciException {

        if(numero < 0) {
            throw new FibonnaciException("O número precisa ser maior ou igual à zero!");
        }
    }

    public static int geraFibonnaciLinear(int numero) {

        int atual = 0;
        int sucessor = 1;

        for (int i = 0; i < numero; i++) {
            //Guardo a variável atual
            int auxiliar = atual;
            atual = sucessor;
            sucessor = auxiliar + sucessor;
        }

        return atual;
    }
}
