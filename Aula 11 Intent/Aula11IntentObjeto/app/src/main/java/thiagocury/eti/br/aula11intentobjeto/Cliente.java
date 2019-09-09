package thiagocury.eti.br.aula11intentobjeto;

import java.io.Serializable;

/**
 * Created by Alunos on 14/12/2016.
 */

public class Cliente implements Serializable{

    private String nome;
    private int idade;

    public Cliente() {
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
        return "\nNome = " + nome +
                "\nIdade = " + idade;
    }
}
