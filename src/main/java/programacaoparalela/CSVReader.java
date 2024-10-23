package main.java.programacaoparalela;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVReader implements Runnable {
    private final String nomeArquivo;
    private final List<ProdutoDTO> produtosGlobal;

    public CSVReader(String nomeArquivo, List<ProdutoDTO> produtos) {
        this.nomeArquivo = nomeArquivo;
        this.produtosGlobal = produtos;
    }

    @Override
    public void run() {
        try {
            Files.lines(Paths.get(nomeArquivo))
                    .skip(1)
                    .map(linha -> linha.split(","))
                    .map(dados -> new ProdutoDTO(
                            Integer.parseInt(dados[0]),
                            dados[1],
                            Double.parseDouble(dados[2])))
                    .forEach(produto -> produtosGlobal.add(produto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
