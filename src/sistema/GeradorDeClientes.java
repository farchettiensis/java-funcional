package sistema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class GeradorDeClientes {
    public static void main(String[] args) {
        Supplier<Cliente> clienteSupplier = gerarClienteAleatorio();
        List<Cliente> clientesGerados = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            clientesGerados.add(clienteSupplier.get());
        }

        System.out.println("Clientes gerados automaticamente:");
        clientesGerados.forEach(cliente -> {
            System.out.println("Nome: " + cliente.getNome() +
                    ", Email: " + cliente.getEmail() +
                    ", Idade: " + cliente.getIdade() +
                    ", VIP: " + cliente.isVip());
        });
    }

    private static Supplier<Cliente> gerarClienteAleatorio() {
        List<String> nomes = Arrays.asList("Camelo", "Teobaldo", "Cabelo", "Paçoca", "Jamil");
        List<String> sobrenomes = Arrays.asList("Azulejo", "Maternidade", "Silent Hill 2", "Longlegs", "Snake Eyes");
        List<String> dominios = Arrays.asList("outlook.com", "co.uk", "hotmail.com", "gmail.com", "yahoo.com");

        Random random = new Random();

        return () -> {
            String nome = nomes.get(random.nextInt(nomes.size())) + " " + sobrenomes.get(random.nextInt(sobrenomes.size()));
            String email = nome.toLowerCase().replace(" ", ".") + "@" + dominios.get(random.nextInt(dominios.size()));
            int idade = random.nextInt(100) + 18;

            boolean isVip = random.nextBoolean();

            return new Cliente(nome, email, idade, isVip);
        };
    }
}