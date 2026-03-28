package crud;

public class Cliente{
    private String nome;
    private String email;
    private int idade;

    public Cliente(){
        nome = null;
        email = null;
        idade = 0;
    }
    public Cliente(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
}