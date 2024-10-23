package main.java.programacaoparalela;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Testes {
    public static void main(String[] args) throws InterruptedException {
        List<String> listaArquivos = Arrays.asList(
                "src/aula06/produtos1.csv",
                "src/aula06/produtos2.csv",
                "src/aula06/produtos3.csv",
                "src/aula06/produtos3.csv",
                "src/aula06/produtos3.csv",
                "src/aula06/produtos3.csv"
        );

        List<ProdutoDTO> produtosGlobal = Collections.synchronizedList(new ArrayList<>());

        List<Thread> listThreads = new ArrayList<>();

        for (String nomeArquivo : listaArquivos) {
            Thread thread = new Thread(new CSVReader(nomeArquivo, produtosGlobal));
            listThreads.add(thread);
            thread.start();
        }

        for (Thread thread : listThreads) {
            thread.join();
        }

        produtosGlobal.forEach(System.out::println);

        System.out.println(produtosGlobal.size());
        System.out.println(listThreads.size());

//        List<ProdutoDTO> listaFiltrada = produtosGlobal
//                .stream()
//                .filter(produto -> produto.getValor() > 150)
//                .toList();
//
//        listaFiltrada.forEach(System.out::println);
    }
}
