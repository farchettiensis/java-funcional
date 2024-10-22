package main.java.programacaoparalela;

public class ImpressaoOrdenada {

    private static final int LIMITE = 10;
    private int numeroAtual = 1;

    public static void main(String[] args) {

        ImpressaoOrdenada op = new ImpressaoOrdenada();
        for (int i = 1; i <= LIMITE; i++) {
            Thread t = new Thread(new JobImpressao(op, i), "Thread-" + i);
            t.start();
        }
    }

    public static class JobImpressao implements Runnable {

        private final ImpressaoOrdenada impressaoOrdenada;
        private final int numeroAtual;

        public JobImpressao(ImpressaoOrdenada impressaoOrdenada, int numeroAtual) {
            this.impressaoOrdenada = impressaoOrdenada;
            this.numeroAtual = numeroAtual;
        }

        @Override
        public void run() {
            synchronized (impressaoOrdenada) {
                while (impressaoOrdenada.numeroAtual != numeroAtual) {
                    try {
                        impressaoOrdenada.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + numeroAtual);
                impressaoOrdenada.numeroAtual++;
                impressaoOrdenada.notifyAll();
            }
        }
    }
}
