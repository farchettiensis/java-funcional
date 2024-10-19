package main.java.lista2;

import java.util.stream.IntStream;

public class TesteStreams {
    public static void main(String[] args) {
//        IntStream.of(1, 2, 3, 5)
//                .map(numero -> numero * 2)
//                .forEach(numero -> System.out.println(numero));

//        double average = IntStream.range(1, 10)
//                .filter(i -> i % 2 == 0)
//                .average()
//                .getAsDouble(); // .orElse(Double.NaN);
//
//        System.out.println("Média: " + average);

        IntStream.range(1, 10)
                .filter(i -> i % 2 == 0)
                .average()
                .ifPresent(mediaPares -> System.out.println(mediaPares));
    }
}
