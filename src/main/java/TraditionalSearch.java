package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TraditionalSearch {
    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<Animal>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));
        animais.add(new Animal("tartaruga", false, true));

        // imprime os animais verificados
        // imprimir(animais, new main.java.VerificaSeSaltador());

        // Predicate
//        imprimir(animais, animal -> animal.podeSaltar());
//        imprimir(animais, (main.java.Animal animal) -> animal.podeNadar());

//        Consumer<main.java.Animal> consumer = animal -> System.out.println(animal);
//        imprimir(animais, consumer);

//        Supplier<Double> geradorDeDoubles = () -> Math.random();
//        System.out.println(geradorDeDoubles.get());

//        Comparator<String> ordemAlfabetica = (string1, string2) -> string1.compareTo(string2);
//        String fulano = "Fulano";
//        String ciclano = "Ciclano";
//        int result = ordemAlfabetica.compare(fulano, ciclano);
//        System.out.println(result);

        Integer[] numbers = {5, 2, 9, 1, 3};
        Comparator<Integer> comparador1 = (a, b) -> a - b;
        Arrays.sort(numbers, comparador1);
        System.out.println(Arrays.toString(numbers));

        Comparator<Integer> comparador2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };

//        Comparator<Integer> comparador3 = Comparator.comparingInt(1, 2);

    }

//    private static void imprimir(List<main.java.Animal> animais, Predicate<main.java.Animal> verificador) {
//        for (main.java.Animal animal : animais) {
//            if (verificador.test(animal)) {
//                System.out.print(animal + " ");
//            }
//        }
//        System.out.println();
//    }

    private static void imprimir(List<Animal> animais, Consumer<Animal> impressao) {
        for (Animal animal : animais) {
            impressao.accept(animal);
        }
        System.out.println();
    }

    private static void generate(Supplier<Integer> gerador) {
        System.out.println(gerador.get());
    }
}