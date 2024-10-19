package main.java;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> funcaoMultiplicacao = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        Integer resultado = funcaoMultiplicacao.apply(5);
        Function<Integer, Integer> funcaoMultiplicacao2 = x -> x * x;

        System.out.println(resultado);

        BiFunction<Integer, Integer, Integer> funcaoBi = (x, y) -> x * y;
        Integer resultadoBi = funcaoBi.apply(10, 8);
        System.out.println(resultadoBi);
    }
}
