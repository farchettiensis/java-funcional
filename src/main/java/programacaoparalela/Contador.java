package main.java.programacaoparalela;

public class Contador {
    //    private int contador = 0;
    private long contador = 1;

    public void incrementar() {
        contador++;
    }

    public synchronized void dobrar() {
        contador *= 2;
    }

    public long getContador() {
        return contador;
    }
}
