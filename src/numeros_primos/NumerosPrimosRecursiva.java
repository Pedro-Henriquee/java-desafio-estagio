package numeros_primos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import numeros_primos.exception.NumerosPrimosException;

public class NumerosPrimosRecursiva {

    public static List<Integer> numerosPrimos = new ArrayList<>();
    public static int numeroSequencia = 2; //O primeiro primo sempre é 2. Logo, a sequência é começada por ele

    public static void main(String[] args) {
        app();
    }

    public static void app() {

        //Tratamento de exceção: Verificar se número recebido é maior que 1 (um)
        try {

            int numeroEntrada = digitaNumero();
            validaNumero(numeroEntrada);

            //Se o número da entrada for diferente de dois, isto é, maior que ele, chamamos a função
            //Caso não seja, colocamos apenas o dois (2) como número primo
            if(numeroEntrada > 2) {
                geraNumerosPrimosRecursiva(numeroEntrada);
            }
            else {
                numerosPrimos.add(2);
            }

            System.out.println("Números primos, feitos de maneira *Recursiva*, até: " + numeroEntrada + " são: " + numerosPrimos);

        } catch (NumerosPrimosException e) {
            System.out.println(e.getMessage());
        }

        //Resetando valores auxiliares
        numeroSequencia = 2;
        numerosPrimos.clear();
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

    public static List<Integer> geraNumerosPrimosRecursiva(int numeroEntrada) {

        //Quando o número da sequência for maior que o da entrada, a recursividade é interrompida
        if(numeroSequencia > numeroEntrada) {
            return numerosPrimos;
        }

        //Verifico se o número da sequência é primo
        if(verficaPrimo(numeroSequencia)) {
            numerosPrimos.add(numeroSequencia);
        }

        //Para verificar os próximos números, basta incrementar o número atual da sequência
        numeroSequencia++;
        return geraNumerosPrimosRecursiva(numeroEntrada);
    }
}
