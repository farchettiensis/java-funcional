package main.java.programacaoparalela;

public class Exercicio02Alternativo {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Thread t1 = new Thread(new TarefaImpressao(contador), "Thread 1");
        Thread t2 = new Thread(new TarefaImpressao(contador), "Thread 2");
        Thread t3 = new Thread(new TarefaImpressao(contador), "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    static class TarefaImpressao implements Runnable {
        private final Contador contador;

        public TarefaImpressao(Contador contador) {
            this.contador = contador;
        }

        @Override
        public void run() {
            while (true) {
                int valor = contador.incrementarERetornar();
                if (valor > 10) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " - " + valor);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
