package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Stream<String> streamVazia = Stream.empty();    // #elementos 0
        Stream<Integer> unicoElemento = Stream.of(1);   // #elementos 1
        Stream<Integer> usandoVarrags = Stream.of(1, 2, 3); // #elementos 3
        var lista = List.of("a", "b", "c");
        Stream<String> streamDaLista = lista.stream();

        List<Integer> ages = List.of(1, 2, 18, 19, 5);
        List<Integer> adults = ages.stream()
                .filter(age -> age >= 18)
                .collect(Collectors.toList());

        System.out.println(adults);

        Stream.of(1, 2, 3, 4, 5)
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.println(x));

        List<String> names = List.of("Jamil", "Jomil", "Jamilson", "Jamilene", "Jamilenei");
        List<String> upperCaseNames = names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println(upperCaseNames);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
