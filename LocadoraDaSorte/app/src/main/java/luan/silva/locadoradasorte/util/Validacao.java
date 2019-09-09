package luan.silva.locadoradasorte.util;

/**
 * Created by luan on 22/12/16.
 */

public class Validacao {

    public static boolean testarNome(String nome){
        return nome.matches("^[a-z]{2,50}$");
    }
    public static boolean testarEmail(String email){
        return email.matches("^[a-z0-9_-]{2,30}@(hotmail.com|gmail.com|yahoo.com|yahoo.com.br|outlook.com)$");
    }
    public static boolean testarSenha(String senha){
        return senha.matches("^[a-z0-9]{6,30}$");
    }
    public static boolean testtarData(String data){
        return data.matches("^[1-3]{1}[0-9]{1}/(01|02|03|04|05|06|07|08|09|10|11|12){1}/(1998|1997|1996|1995|1994|1993|1992|1991|1990|1989|1988|1987|1986|1985|1984|1983|1982|1981|1980|1979|1978|1977|1976|1975|1974|1973|1972|1971|1970|1969|1968|1967|1966|1965|1964|1963|1962|1961|1960|1968|1967|1966|1965|1964|1963|1962|1961|1960|1959|1958|1957|1959|1958|1957|1956|1955|1954|1953|1952|1951|1950|1949|1948|1947|1946|1945|1944|1943|1942|1941|1940|1939|1938|1937|1936|1935|1934|1933|1932|1931|1930|1929|1928|1927|1926|1925|1924|1923|1922|1921|1920|1919|1918|1917|1916|1915|1914|1913|1912|1911|1910){1}$");
    }
    public static boolean testarTelefone(String telefone){
        return telefone.matches("^[0-9]{10,11}$");
    }//51996102410
    public static boolean testarCpf(String cpf){
        return cpf.matches("^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$");
    }

}
