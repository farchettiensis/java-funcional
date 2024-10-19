package main.java.lista2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Multiplicador {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
        System.out.println(dobrar(numeros));
    }

    public static List<Integer> dobrar(List<Integer> numeros) {
        UnaryOperator<Integer> dobrarNumero = (Integer numero) -> numero * 2;

        numeros.replaceAll(dobrarNumero);
        return numeros;
    }
}
