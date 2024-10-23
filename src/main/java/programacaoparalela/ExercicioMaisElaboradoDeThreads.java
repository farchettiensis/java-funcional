package main.java.programacaoparalela;

import main.java.inputoutput.Produto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExercicioMaisElaboradoDeThreads {

    public static void main(String[] args) {
//        List<Produto> produtos1 = new ExercicioMaisElaboradoDeThreads().carregarProdutosSimplificado();
//        produtos1.forEach(System.out::println);
//
//        List<Produto> produtos2 = new ExercicioMaisElaboradoDeThreads().carregarProdutosComThreads();
//        produtos2.forEach(System.out::println);
//
//        List<Produto> produtos3 = new ExercicioMaisElaboradoDeThreads().carregarProdutosComThreadsUsandoFile();
//        produtos3.forEach(System.out::println);

        List<Produto> produtos4 = new ExercicioMaisElaboradoDeThreads().carregarProdutosComThreadsUsandoFileFiltrado();
        produtos4.forEach(produto -> System.out.println(produto));

//        List<Produto> produtos5 = new ExercicioMaisElaboradoDeThreads().carregarProdutosComThreadsUsandoFileFiltradoSortado();
//        produtos5.forEach(System.out::println);
    }

    public List<Produto> carregarProdutosComThreadsUsandoFileFiltrado() {
        String[] fileNames = {"produtos1.csv", "produtos2.csv", "produtos3.csv"};
        List<Produto> todosProdutos = new ArrayList<>(); // final
        List<Thread> threads = new ArrayList<>();
        List<List<Produto>> results = new ArrayList<>(); // lista de cada thread

        for (String fileName : fileNames) {
            List<Produto> produtos = new ArrayList<>();
            results.add(produtos);

            Thread thread = new Thread(() -> {
                try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/" + fileName))) {
                    List<Produto> produtosDoArquivo = lines
                            .skip(1)
                            .map(line -> line.split(","))
                            .map(parts -> {
                                int id = Integer.parseInt(parts[0].trim());
                                String nome = parts[1].trim();
                                double preco = Double.parseDouble(parts[2].trim());
                                return new Produto(id, nome, preco);
                            })
                            .filter(produto -> produto.preco() > 150)
                            .collect(Collectors.toList());

                    synchronized (produtos) {
                        produtos.addAll(produtosDoArquivo);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (List<Produto> produtos : results) {
            todosProdutos.addAll(produtos);
        }

        return todosProdutos;
    }

    public List<Produto> carregarProdutosComThreadsUsandoFileFiltradoSortado() {
        String[] fileNames = {"produtos1.csv", "produtos2.csv", "produtos3.csv"};
        List<Produto> todosProdutos = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        List<List<Produto>> results = new ArrayList<>();

        for (String fileName : fileNames) {
            List<Produto> produtos = new ArrayList<>();
            results.add(produtos);

            Thread thread = new Thread(() -> {
                try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/" + fileName))) {
                    List<Produto> produtosDoArquivo = lines
                            .skip(1)
                            .map(line -> line.split(","))
                            .map(parts -> {
                                int id = Integer.parseInt(parts[0].trim());
                                String nome = parts[1].trim();
                                double preco = Double.parseDouble(parts[2].trim());
                                return new Produto(id, nome, preco);
                            })
                            .collect(Collectors.toList());

                    synchronized (produtos) {
                        produtos.addAll(produtosDoArquivo);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (List<Produto> produtos : results) {
            todosProdutos.addAll(produtos);
        }

        List<Produto> produtosFiltradosEOrdenados = todosProdutos.stream()
                .filter(produto -> produto.preco() > 150)
                .sorted(Comparator.comparingInt(Produto::id))
                .collect(Collectors.toList());

        return produtosFiltradosEOrdenados;
    }


    public List<Produto> carregarProdutosComThreadsUsandoFile() {
        String[] fileNames = {"produtos1.csv", "produtos2.csv", "produtos3.csv"};
        List<Produto> todosProdutos = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        List<List<Produto>> results = new ArrayList<>();

        for (String fileName : fileNames) {
            List<Produto> produtos = new ArrayList<>();
            results.add(produtos);

            Thread thread = new Thread(() -> {
                try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/" + fileName))) {
                    List<Produto> produtosDoArquivo = lines
                            .skip(1)
                            .map(line -> line.split(","))
                            .map(parts -> {
                                String id = parts[0];
                                String nome = parts[1].trim();
                                String preco = parts[2].trim();
                                return new Produto(Integer.parseInt(id), nome, Double.parseDouble(preco));
                            })
                            .collect(Collectors.toList());

                    synchronized (produtos) {
                        produtos.addAll(produtosDoArquivo);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (List<Produto> produtos : results) {
            todosProdutos.addAll(produtos);
        }

        return todosProdutos;
    }

    public List<Produto> carregarProdutosSimplificado() {
        String[] fileNames = {"produtos1.csv", "produtos2.csv", "produtos3.csv"};
        List<Produto> todosProdutos = new ArrayList<>();

        for (String fileName : fileNames) {
            try {
                Path path = Paths.get("src/main/resources/" + fileName);
                List<Produto> produtos = Files.lines(path)
                        .skip(1)
                        .map(line -> line.split(","))
                        .map(parts -> {
                            String id = parts[0].trim();
                            String nome = parts[1].trim();
                            String preco = parts[2].trim();
                            return new Produto(Integer.parseInt(id), nome, Double.parseDouble(preco));
                        })
                        .collect(Collectors.toList());
                todosProdutos.addAll(produtos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return todosProdutos;
    }


    public List<Produto> carregarProdutosSemThreads() {
        String[] fileNames = {"produtos1.csv", "produtos2.csv", "produtos3.csv"};

        try {
            return java.util.Arrays.stream(fileNames)
                    .flatMap(fileName -> {
                        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
                        if (inputStream == null) {
                            throw new IllegalArgumentException("Arquivo não encontrado: " + fileName);
                        }
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        return bufferedReader.lines().skip(1);
                    })
                    .map(this::lineToProduto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Produto lineToProduto(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new RuntimeException("Linha inválida: " + line);
        }
        return new Produto(Integer.parseInt(parts[0]), parts[1].trim(), Double.parseDouble(parts[2].trim()));
    }
}

