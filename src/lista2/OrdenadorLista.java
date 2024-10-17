package lista2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenadorLista {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 2};
        int[] arrayOrdenado = ordenarListaComLambda(array);
        System.out.println(Arrays.toString(arrayOrdenado));
    }

    public static int[] ordenarListaComLambda(int[] array) {
        List<Integer> lista = Arrays.stream(array).boxed().sorted((a, b) -> a - b).collect(Collectors.toList());
        return lista.stream().mapToInt(i -> i).toArray();
    }
}
