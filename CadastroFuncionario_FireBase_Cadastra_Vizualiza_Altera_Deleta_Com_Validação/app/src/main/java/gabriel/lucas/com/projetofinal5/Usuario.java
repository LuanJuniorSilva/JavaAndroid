package gabriel.lucas.com.projetofinal5;

import java.io.Serializable;

/**
 * Created by User on 22/12/2016.
 */

public class Usuario implements Serializable {

    private String chavao;
    private String nome;
    private String endereco;
    private String fone;
    private String cpf;
    private String email;

    public Usuario(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChavao() {
        return chavao;
    }

    public void setChavao(String chavao) {
        this.chavao = chavao;
    }

    @Override
    public String toString() {
        return "Fucionario: "+nome+"\nCPF: "+cpf;
    }

    public String toString2() {
        return "\nEndereço: "+endereco+"\nTelefone: "+fone+ "\nCPF: "+cpf+"\nEmail: "+email;
    }

}//fecha class
