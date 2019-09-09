package luan.silva.exercicioaula09;

/**
 * Created by Alunos on 12/12/2016.
 */

public class Cliente {

    private String nome;
    private String sexo;
    private String estadoCivil;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Cliente() {
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "\nNome: "+nome
                +"\nSexo: "+ sexo
                +"\nEstado Civil: "+ estadoCivil
                +"\nRua: "+ rua
                +"\nBairro: "+ bairro
                +"\nCidade: "+ cidade
                +"\nEstado: "+ estado;
    }
}
