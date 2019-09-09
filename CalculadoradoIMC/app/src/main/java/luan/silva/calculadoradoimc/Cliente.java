package luan.silva.calculadoradoimc;

/**
 * Created by luan on 06/12/16.
 */

public class Cliente {
    private String nome;
    private Double peso;
    private Double altura;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    private void setAltura(Double altura) {
        this.altura = altura;
    }

    public double calcularAltura(int m, double c){
        double res =  (m * 100 + c)/100;
        this.setAltura(res);
        return res;
    }

    public  double calcularIMC(){
        return (this.getPeso()/(this.getAltura() * this.getAltura()));
    }

    public String status(){
        if(this.calcularIMC() <= 20){
            return "Você está abaixo do peso";
        }else if(this.calcularIMC() > 20 && this.calcularIMC() <= 25){
            return "Você esta no peso ideal";
        }else if(this.calcularIMC() > 25 && this.calcularIMC() <= 30){
            return "Você esta em SobrePeso";
        }else if(this.calcularIMC() > 30 && this.calcularIMC() <= 35){
            return "Você esta com Obesidade Moderada";
        }else if(this.calcularIMC() > 35 && this.calcularIMC() <= 40){
            return "Você esta com Obesidade Severa";
        }else if(this.calcularIMC() > 40 && this.calcularIMC() <= 50){
            return "Você esta com Obesidade Mórbida";
        }else{
            return "Você esta com Obesidade Mórbida";
        }
    }

    @Override
    public String toString() {
        return  "\nnome: "+this.getNome()
                +"\npeso: "+this.getPeso()
                +"\naltura: "+this.getAltura()
                +"\nIMC: "+this.calcularIMC();
    }
}
