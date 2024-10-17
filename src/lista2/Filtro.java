package lista2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filtro {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(-1);
        numeros.add(10);
        numeros.add(-10);
        numeros.add(7);
        numeros.add(-7);

        List<Integer> numerosFiltrados = removerNegativos(numeros);
        System.out.println(numerosFiltrados);
    }

    public static List<Integer> removerNegativos(List<Integer> numeros) {
        Predicate<Integer> isNegative = numero -> numero < 0;

        numeros.removeIf(isNegative);
        return numeros;
    }
}
