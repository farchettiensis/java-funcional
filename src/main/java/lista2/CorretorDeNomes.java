package main.java.lista2;

import java.util.List;
import java.util.stream.Collectors;

class CorretorDeNomes {
    public static void main(String[] args) {
        CorretorDeNomes corretorDeNomes = new CorretorDeNomes();
        List<String> nomes = List.of("jamil", "Jojoca", "Dr. Jamil", "Jamil Decadente Edição Limitada");
        List<String> nomesCorrigidos = corretorDeNomes.corrigir(nomes);
        System.out.println(nomesCorrigidos);
    }

    public List<String> corrigir(List<String> nomes) {
        return nomes.stream().map(nome -> nome.toUpperCase()).collect(Collectors.toList());
    }
}
