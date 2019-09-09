package firebase.aula.aulafirebase;

/**
 * Created by Alunos on 20/12/2016.
 */

public class Pessoa {
    private String nome;
    private int idade;
    private int ola = 0;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.getNome()
                +"\n"+this.getIdade();
    }
}
