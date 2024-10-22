package main.java.programacaoparalela;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        ThreadContador threadContador = new ThreadContador(contador);

        List<Thread> threadList = List.of(
                new Thread(threadContador),
                new Thread(threadContador),
                new Thread(threadContador)
        );

//        threadList.parallelStream().forEach(Thread::start);

        threadList.forEach(Thread::start);

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

//        Thread thread1 = new Thread(threadContador);
//        Thread thread2 = new Thread(threadContador);
//        Thread thread3 = new Thread(threadContador);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//
//        thread1.join();
//        thread2.join();
//        thread3.join();

        System.out.println("Encerrou");
    }
}
