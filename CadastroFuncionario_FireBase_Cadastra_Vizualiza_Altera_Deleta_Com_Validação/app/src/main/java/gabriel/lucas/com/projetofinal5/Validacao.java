package gabriel.lucas.com.projetofinal5;

/**
 * Created by User on 27/12/2016.
 */

public class Validacao {
    public static boolean testarNome(String nome){return nome.matches("^[A-z ]{2,20}$");}
    public static boolean testarEndereco(String endereco){return endereco.matches("^[A-zá-ç0-9 ]{2,20}$");}
    public static boolean testarTelefone(String fone){return fone.matches("^[0-9]{11,11}$");}
    public static boolean testarCpf(String cpf){return cpf.matches("^[0-9]{11,11}$");}
    public static boolean testarEmail(String email){return email.matches("^[a-z@.0-9]{2,100}");}


}//class
