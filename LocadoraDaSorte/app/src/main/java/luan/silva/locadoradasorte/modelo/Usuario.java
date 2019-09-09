package luan.silva.locadoradasorte.modelo;

/**
 * Created by luan on 22/12/16.
 */

public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String sexo;
    private String senha;
    private String data;
    private String login;
    private String cpf;

    public Usuario() {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setData(String data){
        this.data = data;
    }
    public String getData(){
        return this.data;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public  String getCpf(){
        return  this.cpf;
    }

    @Override
    public String toString() {
        return "\n Preste Atenção esses dados não poderão ser alterados" +
                "\nNome: "+nome
                +"\n Email: "+email
                +"\n Telefone: "+telefone
                +"\n Sexo: "+senha
                +"\n Data de Nascimento: "+data
                +"\n Cpf: "+cpf+
                "\n Se está tudo certo clique em confirmar se não clique em cancelar ";
    }
}
