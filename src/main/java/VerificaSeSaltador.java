package main.java;

public class VerificaSeSaltador implements Verificador {

    @Override
    public boolean verificar(Animal a) {
        return a.podeSaltar();
    }
}