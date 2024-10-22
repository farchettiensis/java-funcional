package main.java.programacaoparalela;

public class Exercicio01 implements Runnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Exercicio01(), "Thread 1");
        Thread t2 = new Thread(new Exercicio01(), "Thread 2");
        Thread t3 = new Thread(new Exercicio01(), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Número: " + i);
        }

        System.out.println("Finalizou a thread " + Thread.currentThread().getName());
    }
}

