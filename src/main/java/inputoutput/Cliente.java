package main.java.inputoutput;

public record Cliente(
        int clienteID,
        String origem,
        int idade,
        double salarioAnual,
        int nota,
        String profissao,
        int experienciaTrabalho,
        int tamanhoFamilia
) {
}

