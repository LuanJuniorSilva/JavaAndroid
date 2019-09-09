package luan.silva.provaluan.modelo;

import java.util.ArrayList;

/**
 * Created by Alunos on 13/12/2016.
 */

public class Meta {
    private String nomeMeta;
    private Double pedoAtual;
    private Double pesoDesejado;
    private String sexo;
    private ArrayList<String>turno;
    private String opcao;

    public Meta() {
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public Double getPedoAtual() {
        return pedoAtual;
    }

    public void setPedoAtual(Double pedoAtual) {
        this.pedoAtual = pedoAtual;
    }

    public Double getPesoDesejado() {
        return pesoDesejado;
    }

    public void setPesoDesejado(Double pesoDesejado) {
        this.pesoDesejado = pesoDesejado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<String> getTurno() {
        return turno;
    }

    public void setTurno(ArrayList<String> turno) {
        this.turno = turno;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public String mostrarRes(){
        String res;
        if(this.getOpcao().equalsIgnoreCase("Leve")){
                res = " Trabalhos domésticos de esforço leve a modreado, caminhadas para atividades relacionadas ao cotidiano e ficar sentado por várias horas.\n" +
                    "Caminhadas além das mesmas atividades relacionadas ao compoartament sednetário. Até 3 horas de atividad física por semana.";
        }else if(this.getOpcao().equalsIgnoreCase("Intenso")){
                res = "Ciclismo de intensidade moderada, corrida, pular corda, jogar tênis e além das atividades relacionadas ao comportamento moderado. Acima de 12 horas de atividade física por semana.";
        }else{
                res = "Ginástica aeróbica, corrida, natação, jogar tênicas, além das atividades relacionadas ao compoartamente leve. Até 12 horas de atividade física por semana.";
        }
        return res;
    }

    @Override
    public String toString() {
        return
                "\nnomeMeta='" + nomeMeta + '\'' +
                "\n pedoAtual=" + pedoAtual +
                "\n pesoDesejado=" + pesoDesejado +
                "\n sexo='" + sexo + '\'' +
                "\n turno=" + turno +
                "\n opcao='" + opcao + '\'' +
                "\nDica: "+mostrarRes();
    }
}
