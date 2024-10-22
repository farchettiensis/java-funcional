package main.java.programacaoparalela;

import java.util.stream.IntStream;

public class Exercicio02 {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Thread t1 = new Thread(new TarefaImpressao(contador), "Thread 1");
        Thread t2 = new Thread(new TarefaImpressao(contador), "Thread 2");
        Thread t3 = new Thread(new TarefaImpressao(contador), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class TarefaImpressao implements Runnable {
        private final Contador contador;

        public TarefaImpressao(Contador contador) {
            this.contador = contador;
        }

        @Override
        public synchronized void run() {
            IntStream.iterate(contador.incrementarERetornar(),
                            valor -> valor <= 10,
                            valor -> contador.incrementarERetornar()
                    )
                    .forEach(valor -> {
                        System.out.println(Thread.currentThread().getName() + " - " + valor);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    static class Contador {
        private int valor = 0;

        public synchronized int incrementarERetornar() {
            valor++;
            return valor;
        }
    }
}
