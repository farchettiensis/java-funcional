package lista2;

import java.util.Optional;

class StringOptional {
    public static void main(String[] args) {
        StringOptional stringOptional = new StringOptional();

        Optional<String> optional1 = stringOptional.optionalOfString("Olá, mundo!");
        System.out.println("Optional1: " + optional1);

        Optional<String> optional2 = stringOptional.optionalOfString("");
        System.out.println("Optional2: " + optional2);

        Optional<String> optional3 = stringOptional.optionalOfString(null);
        System.out.println("Optional3: " + optional3);
    }

    public Optional<String> optionalOfString(String text) {
        return (text == null || text.trim().isEmpty()) ? Optional.empty() : Optional.of(text);
//        return (text == null || text.isEmpty()) ? Optional.empty() : Optional.of(text);
    }
}
