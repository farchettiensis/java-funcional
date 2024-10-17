package sistema;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GeradorAleatorio {
    static List<Character> listaCaracteres = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    static Random random = new Random();

    public static void main(String[] args) {
        Supplier<Character> caractereAleatorio = () -> listaCaracteres.get(random.nextInt(1) + 5);
        Character c = caractereAleatorio.get();
        System.out.println("Caractere não aleatório: " + c);

        Predicate<Character> isF = ch -> ch.equals('f');

        if (isF.test(c)) {
            System.out.println("É 'f'");
        } else {
            System.out.println("Não é 'f'");
        }
    }
}
