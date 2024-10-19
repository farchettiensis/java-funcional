package main.java.lista2;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Escreva um metodo em java chamado calculaMediaPares que recebe um array de inteiros e retorna a média dos numeros pares do array.
 */
public class MediaPares {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double media = calculaMediaPares2(numeros);
        System.out.println(media);
    }

    public static double calculaMediaPares(int[] input) {
        return IntStream.of(input)
                .filter(i -> i % 2 == 0)
                .average()
                .getAsDouble();
    }

    public static double calculaMediaPares2(int[] input) {
        return Arrays.stream(input)
                .filter(num -> num % 2 == 0)
                .average()
                .orElse(Double.NaN);
    }
}
