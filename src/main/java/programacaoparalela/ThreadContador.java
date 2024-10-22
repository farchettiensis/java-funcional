package main.java.programacaoparalela;

public class ThreadContador implements Runnable {
    Contador contador = new Contador();

    public ThreadContador() {
    }

    public ThreadContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            contador.incrementar();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Contador final: " + contador.getContador());
    }

//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            contador.dobrar();
//        }
//
//        System.out.println("Contador final: " + contador.getContador());
//    }
}
