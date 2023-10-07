package fibonnaci;

import java.util.Scanner;

import fibonnaci.exception.FibonnaciException;

public class FibonnaciRecursiva {

    public static void main(String[] args) {
        app();
    }

    public static void app() {
        //Tratamento de exceção: Verificar se número recebido não é negativo
        try {

            int numero = digitaNumero();
            validaNumero(numero);

            int resultadoRecursiva = geraFibonnaciRecursiva(numero);
            System.out.println("Resultado da sequência de Fibonnaci, feita de maneira *Recursiva* é: " + resultadoRecursiva);

        } catch (FibonnaciException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int digitaNumero() {

        Scanner s = new Scanner(System.in);
        System.out.println("Digite um número não negativo: ");
        int numeroEntrada = s.nextInt();
        s.close();

        return numeroEntrada;
    }

    public static void validaNumero(int numero) throws FibonnaciException {

        if(numero < 0) {
            throw new FibonnaciException("O número precisa ser maior ou igual à zero!");
        }
    }

    public static int geraFibonnaciRecursiva(int numero) {

        //Caso seja menor que zero (negativo), não realiza a sequência
        if(numero < 0) {
            return 0;
        }
        //Caso seja igual à 1, o resultado é o próprio número
        else if(numero == 1) {
            return numero;
        }

        return geraFibonnaciRecursiva(numero - 1) + geraFibonnaciRecursiva(numero - 2);
    }
}
