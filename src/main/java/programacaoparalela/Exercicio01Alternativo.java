package main.java.programacaoparalela;

public class Exercicio01Alternativo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TarefaImpressao(), "Thread 1");
        Thread t2 = new Thread(new TarefaImpressao(), "Thread 2");
        Thread t3 = new Thread(new TarefaImpressao(), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class TarefaImpressao implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
