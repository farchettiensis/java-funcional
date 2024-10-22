package main.java.programacaoparalela;

public class AulaThread {
    public static void main(String[] args) {
        PrimeiraThread t1 = new PrimeiraThread();
        PrimeiraThread t2 = new PrimeiraThread();
        PrimeiraThread t3 = new PrimeiraThread();
        PrimeiraThread t4 = new PrimeiraThread();
        PrimeiraThread t5 = new PrimeiraThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
