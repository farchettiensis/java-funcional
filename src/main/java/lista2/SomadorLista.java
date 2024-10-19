package main.java.lista2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SomadorLista {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        System.out.println(somaLista1(numeros));
    }

    public static int somaLista1(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static int somaLista2(int[] array) {
        return Arrays.stream(array)
                .reduce(0, (acc, numero) -> acc + numero);
    }

    public static int somaLista3(int[] array) {
        List<Integer> lista = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        return lista.stream().mapToInt(i -> i.intValue()).sum();
    }
}
