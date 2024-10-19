package main.java;/*
Utilize a interface Predicate para verificar se um número é positivo,
se uma string começa com a letra "A" e se o tamanho de uma lista de inteiros é maior que 5.
*/

import java.util.List;
import java.util.function.Predicate;

public class PredicatePratica {
    public static void main(String[] args) {
        testarNumerosPositivos();
        testarComecaComA();
        testarTamanhoDaLista();
    }

    public static void testarNumerosPositivos() {
        Predicate<Integer> isPositive = number -> number > 0;
        System.out.println("É positivo teste 1: " + isPositive.test(7));
        System.out.println("É positivo teste 2: " + isPositive.test(-7));
    }

    public static void testarComecaComA() {
        Predicate<String> startsWithA = word -> word.toUpperCase().startsWith("A");
        System.out.println("Começa com 'A' teste 1: " + startsWithA.test("Abacate"));
        System.out.println("Começa com 'A' teste 2: " + startsWithA.test("amarillo"));
        System.out.println("Começa com 'A' teste 3: " + startsWithA.test("Rivotril"));
    }

    public static void testarTamanhoDaLista() {
        Predicate<List<Integer>> isListGreaterThanFive = lista -> lista.size() > 5;
        List<Integer> lista1 = List.of(1, 2, 3, 4, 5);
        List<Integer> lista2 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lista3 = List.of(1, 2, 3, 4);
        System.out.println("Tamanho lista teste 1: " + isListGreaterThanFive.test(lista1));
        System.out.println("Tamanho lista teste 2: " + isListGreaterThanFive.test(lista2));
        System.out.println("Tamanho lista teste 3: " + isListGreaterThanFive.test(lista3));
    }
}
