package main.java.programacaoparalela;

public class PrimeiraThread extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

        System.out.println(Thread.currentThread().getName() + " ended.");
    }
}
