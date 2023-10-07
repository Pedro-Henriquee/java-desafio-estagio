package numeros_primos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import numeros_primos.exception.NumerosPrimosException;

public class NumerosPrimosLinear {

    public static void main(String[] args) {
        app();
    }

    public static void app() {

        //Tratamento de exceção: Verificar se número recebido é maior que um (1)
        try {

            List<Integer> numerosPrimos = new ArrayList<>();

            int numeroEntrada = digitaNumero();
            validaNumero(numeroEntrada);

            //Se o número da entrada for diferente de dois (2), isto é, maior que ele, chamamos a função
            if(numeroEntrada > 2) {
                numerosPrimos = geraNumerosPrimosLinear(numeroEntrada);
            }
            else {
                numerosPrimos.add(2);
            }

            System.out.println("Números primos, feitos de maneira *Linear*, até: " + numeroEntrada + " são: " + numerosPrimos);

        } catch (NumerosPrimosException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int digitaNumero() {

        Scanner s = new Scanner(System.in);
        System.out.println("Digite um número maior que 1: ");
        int numeroEntrada = s.nextInt();
        s.close();

        return numeroEntrada;
    }

    public static void validaNumero(int numero) throws NumerosPrimosException {

        if(numero <= 1) {
            throw new NumerosPrimosException("O número deve ser maior que 1!");
        }
    }

    public static boolean verficaPrimo(int numero) {

        //Verificação se um número é primo, caso tenha algum divisor, isso é, resto 0, antes dele
        for (int i = 2; i < numero; i++) {
            if(numero % i == 0 ) {
                return false;
            }
        }

        return true;
    }


    public static List<Integer> geraNumerosPrimosLinear(int numero) {

        List<Integer> numerosPrimos = new ArrayList<>();

        for (int i = 2; i < numero; i++) {

            // Verificação: analisar se o número (i) é primo
            boolean primo = verficaPrimo(i);

            //Se for primo, adiciona no ArrayList
            if(primo) {
                numerosPrimos.add(i);
            }
        }

        return numerosPrimos;
    }
}
