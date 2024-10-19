package main.java.inputoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClienteIO {

    public static void main(String[] args) throws IOException {
        impressaoFuncional();
    }

    public static void impressaoFuncional() {
        String caminhoArquivo = "src/main/resources/clientes.csv";

        try {
            Files.lines(Paths.get(caminhoArquivo))
                    .skip(1)
                    .map(linha -> linha.split(";"))
                    .map(dados -> new Cliente(
                            Integer.parseInt(dados[0]),
                            dados[1],
                            Integer.parseInt(dados[2]),
                            Double.parseDouble(dados[3]),
                            Integer.parseInt(dados[4]),
                            dados[5],
                            Integer.parseInt(dados[6]),
                            Integer.parseInt(dados[7])
                    ))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

