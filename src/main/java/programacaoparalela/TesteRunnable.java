package main.java.programacaoparalela;

public class TesteRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Teste");

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Encerrou");
    }
}
