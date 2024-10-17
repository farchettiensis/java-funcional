package sistema;

public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private boolean isVip;

    public Cliente(String nome, String email, int idade, boolean isVip) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.isVip = isVip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}
