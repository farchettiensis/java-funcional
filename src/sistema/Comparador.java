package sistema;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparador {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Jomil", "email@email.com", 25, true));
        clientes.add(new Cliente("Jamil", "email@email.com", 26, true));
        clientes.add(new Cliente("Jamil", "email@email.com", 27, true));
        clientes.add(new Cliente("Jamil", "email@email.com", 28, true));
        clientes.add(new Cliente("Jamil", "email@email.com", 29, true));

        Comparator<Cliente> comparadorClientes = (c1, c2) -> {
            int resultado = c1.getNome().compareToIgnoreCase(c2.getNome());
            resultado = resultado == 0 ? Integer.compare(c2.getIdade(), c1.getIdade()) : resultado;
            return resultado;
        };

        clientes.sort(comparadorClientes);
        clientes.forEach(cliente -> System.out.println(cliente.getNome() + " (" + cliente.getIdade() + " anos)"));

    }
}
