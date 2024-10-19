package main.java.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AulaLerArquivos {
    public static void main(String[] args) throws IOException {
        String caminhoArquivo = "src/main/resources/data.txt";
        String linha;

        FileReader fileReader = new FileReader(caminhoArquivo);
        BufferedReader buffered = new BufferedReader(fileReader);

        while ((linha = buffered.readLine()) != null) {
            System.out.println("Dados: " + linha);
        }

        buffered.close();
        fileReader.close();

//        imprimeProdutos();
        System.out.println();
//        imprimeProdutoObjeto();
        impressaoFuncional();
    }

    public static void imprimeProdutos() {
        String caminhoArquivo = "src/main/resources/produtos.csv";

        try {
            String linha;

            FileReader fileReader = new FileReader(caminhoArquivo);
            BufferedReader buffered = new BufferedReader(fileReader);

            buffered.readLine();

            while ((linha = buffered.readLine()) != null) {
                String[] dados = linha.split(";");
                System.out.println("id: " + dados[0] + " *** produto: " + dados[1] + "*** preço: " + dados[2]);
            }
        } catch (IOException e) {
            System.out.println("Erro na leitura de arquivo.");
            System.out.println("Arquivo: " + caminhoArquivo);
            System.out.println(e.getMessage());
        }
    }

    public static void imprimeProdutoObjeto() throws IOException {
        String caminhoArquivo = "src/main/resources/produtos.csv";
        String linha;

        FileReader fileReader = new FileReader(caminhoArquivo);
        BufferedReader buffered = new BufferedReader(fileReader);

        List<Produto> produtos = new ArrayList<>();
        while ((linha = buffered.readLine()) != null) {
            String[] dados = linha.split(";");
            System.out.println("id: " + dados[0] + " *** produto: " + dados[1] + "*** preço: " + dados[2]);

            produtos.add(new Produto(dados[0], dados[1], dados[2]));
        }

        produtos.forEach(System.out::println);
    }

    public static void impressaoFuncional() throws IOException {
//        String caminhoArquivo = "src/main/resources/produtos.csv";
//        Stream<String> linhas = Files.lines(Paths.get(caminhoArquivo));
        // Stream<String[]>
//        linhas.skip(1)
//                .map(linha -> linha.split(";"))
//                .forEach(dados -> System.out.println("id: " + dados[0] + " *** produto: " + dados[1] + "*** preço: " + dados[2]));

//        Files.lines(Paths.get("src/main/resources/produtos.csv"))
//                .skip(1)
//                .map(linha -> linha.split(";"))
//                .forEach(dados ->
//                        System.out.println("id: "
//                                + dados[0] + " *** produto: "
//                                + dados[1] + "*** preço: "
//                                + dados[2]
//                        )
//                );

        System.out.println("Tá aqui");
        Files.lines(Paths.get("src/main/resources/produtos.csv"))
                .skip(1)
                .map(linha -> linha.split(";"))
                .map(dados -> new Produto(dados[0], dados[1], dados[2]))
                .forEach(System.out::println);
    }
}
