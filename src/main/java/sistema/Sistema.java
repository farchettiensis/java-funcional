package main.java.sistema;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Sistema {
    public static void main(String[] args) {
        List<Cliente> listaDeClientes = criarListaDeClientes();
        enviarEmailParaClientes(listaDeClientes);
        System.out.println();

        listaDeClientes.sort(compararClientes());
        listaDeClientes.forEach(cliente -> System.out.println(cliente.getNome() + " (" + cliente.getIdade() + " anos)"));
    }

    private static Comparator<Cliente> compararClientes() {
        return Comparator.comparing(Cliente::getNome)
                .thenComparing(Cliente::getIdade);
    }

    private static void enviarEmailParaClientes(List<Cliente> clientes) {
        Predicate<Cliente> isVipOrAbove60 = cliente -> cliente.getIdade() > 60 || cliente.isVip();
        Consumer<Cliente> enviarEmail = cliente -> System.out.println("Enviando email de agradecimento para " + cliente.getNome() + " (" + cliente.getEmail() + ")");

        clientes.stream()
                .filter(isVipOrAbove60)
                .forEach(enviarEmail);
    }

    private static List<Cliente> criarListaDeClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Aphrodite Hubbard", "a.scelerisque.sed@google.org", 115, false));
        clientes.add(new Cliente("Aphrodite Mcknight", "rutrum.fusce@yahoo.co.uk", 36, true));
        clientes.add(new Cliente("Aphrodite Rhodes", "quam.quis@yahoo.co.uk", 109, true));
        clientes.add(new Cliente("Aphrodite Roach", "elit@protonmail.co.uk", 17, false));
        clientes.add(new Cliente("Aphrodite Rowland", "sed.pharetra.felis@icloud.net", 80, false));
        clientes.add(new Cliente("Aphrodite Wall", "metus@yahoo.net", 95, true));
        clientes.add(new Cliente("Aphrodite Mathis", "libero.est.congue@icloud.edu", 119, false));
        clientes.add(new Cliente("Aphrodite Castaneda", "quisque.purus@protonmail.ca", 81, true));
        clientes.add(new Cliente("Aphrodite Bradley", "in.felis@icloud.com", 95, true));
        clientes.add(new Cliente("Aphrodite Hogan", "orci.adipiscing@hotmail.net", 88, true));
        clientes.add(new Cliente("Aphrodite Ortega", "egestas@outlook.ca", 12, false));
        clientes.add(new Cliente("Aphrodite Conner", "a.neque.nullam@hotmail.net", 9, true));
        clientes.add(new Cliente("Aphrodite Lowe", "fringilla.cursus@hotmail.ca", 48, true));
        clientes.add(new Cliente("Aphrodite Lynn", "nullam@google.ca", 26, false));
        clientes.add(new Cliente("Aphrodite Franklin", "nullam@aol.org", 55, true));
        clientes.add(new Cliente("Aphrodite Chang", "lectus.cum@protonmail.co.uk", 54, false));
        clientes.add(new Cliente("Aphrodite Nicholson", "lectus.ante@outlook.edu", 116, true));
        clientes.add(new Cliente("Aphrodite Byrd", "tincidunt@outlook.ca", 6, true));
        clientes.add(new Cliente("Aphrodite Rivera", "parturient.montes@protonmail.net", 29, false));
        clientes.add(new Cliente("Aphrodite Hart", "ac.turpis.egestas@outlook.org", 30, false));

        return clientes;
    }
}
