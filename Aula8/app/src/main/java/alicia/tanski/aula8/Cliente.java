package alicia.tanski.aula8;

import java.util.ArrayList;

/**
 * @author Alicia Tanski && Luan Junior
 * @since 08/12/2016
 * @version 1.0
 */

public class Cliente {

    private String nome;//editText
    private String sexo;//RadioButton
    private ArrayList<String>prefs;//checkbox

    public Cliente() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getPrefs() {
        return prefs;
    }

    public void setPrefs(ArrayList<String> prefs) {
        this.prefs = prefs;
    }

    public String verificarSexo(){
        if (sexo.equalsIgnoreCase("Masculino")){
            return "Você é homem..";
        }else{
            return "Você é mulher";
        }//fecha else
    }//fehca verificar

    //testa o sexo e volta um numero
    public int verificarSexo1(){
        if (sexo.equalsIgnoreCase("Masculino")){
            return 171;
        }else {
            return 157;
        }//fecha else
    }//verificar sexo1



    @Override
    public String toString() {
        String batata="";
        for (int i=0 ; i<prefs.size(); i++){
            batata = batata + " " + prefs.get(i);
        }//fecha for
        return "Nome: "+nome
                +"\nSexo: "+sexo
                +"\nPrefs: "+batata
                +"\nVerificar: "+verificarSexo()
                +"\nVerificar: "+verificarSexo1();
    }
}//fecha class
