package main.java.lista2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class AnalisadorIdade {
    public static void main(String[] args) {
        AnalisadorIdade analisadorIdade = new AnalisadorIdade();
        Predicate<Integer> verificador = analisadorIdade.criarVerificador();

        List<Integer> idades = List.of(15, 18, 21, 14, 17, 19);
        List<Integer> idadesFiltradas = analisadorIdade.remover(idades, verificador);

        System.out.printf("Idades filtradas: %s%n", idadesFiltradas);
    }

    public Predicate<Integer> criarVerificador() {
        return i -> i < 18;
    }

    public List<Integer> remover(List<Integer> colecao, Predicate<Integer> verificador) {
        return colecao.stream().filter(verificador.negate()).collect(Collectors.toList());
    }
}