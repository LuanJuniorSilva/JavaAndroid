package luan.silva.projetodeaula08;

import java.util.ArrayList;

/**
 * Created by Alunos on 08/12/2016.
 */

public class Produto {

    private String nome;//fim do atributo nome
    private String sexo;//fim do atributo tipo
    private ArrayList<String>cursos;//fim do atributo frete

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<String> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        String msg = "";
        for (int i=0 ; i<cursos.size(); i++){
            msg +=  " " + cursos.get(i);
        }//fecha for
        return   "\nSeu Nome: "+nome
                +"\nSeu Genero: "+sexo
                +"\nSeu Genero: "+msg;
    }
}
