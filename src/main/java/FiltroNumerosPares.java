package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FiltroNumerosPares {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);

        imprimir(numeros, numero -> validaPar(numero));
    }

    private static boolean validaPar(int numero) {
        return numero % 2 == 0;
    }

    private static void imprimir(List<Integer> numeros, Predicate<Integer> verificador) {
        for (Integer numero : numeros) {
            if (verificador.test(numero)) {
                System.out.println(numero);
            }
        }
        System.out.println();
    }
}
