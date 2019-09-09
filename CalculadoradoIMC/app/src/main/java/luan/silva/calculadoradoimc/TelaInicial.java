package luan.silva.calculadoradoimc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {
    //widgets
    private EditText etNome;
    private EditText etPeso;
    private EditText etMetro;
    private EditText etCentimetro;
    private Button btnBotao;

    //objeto

    private Cliente c;

    private String status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        etNome = (EditText) findViewById(R.id.ti_nome);
        etPeso = (EditText) findViewById(R.id.ti_peso);
        etMetro = (EditText) findViewById(R.id.ti_metro);
        etCentimetro = (EditText) findViewById(R.id.ti_centimetro);
        btnBotao = (Button) findViewById(R.id.ti_btn);


        btnBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getBaseContext(),"ola mundo",Toast.LENGTH_LONG).show();
                //instanciar o objeto da Classe
                c = new Cliente();
                c.setNome(etNome.getText().toString());
                c.setPeso(Double.parseDouble(etPeso.getText().toString()));
                c.calcularAltura(Integer.parseInt(etMetro.getText().toString()),Double.parseDouble(etCentimetro.getText().toString()));
                c.calcularIMC();

                String s = getResources().getText(R.string.s_nome)+": "+c.getNome()
                           +"\n"+getResources().getText(R.string.s_peso)+": "+c.getPeso()
                           +"\n"+getResources().getText(R.string.s_altura)+": "+c.getAltura()
                           +"\nIMC: "+c.calcularIMC();

                if(c.calcularIMC() <= 20){
                    s+= "\n"+getResources().getText(R.string.a);
                }else if(c.calcularIMC() > 20 && c.calcularIMC() <= 25){
                    s+= "\n"+getResources().getText(R.string.b);
                }else if(c.calcularIMC() > 25 && c.calcularIMC() <= 30){
                    s+= "\n"+getResources().getText(R.string.c);
                }else if(c.calcularIMC() > 30 && c.calcularIMC() <= 35){
                    s+= "\n"+getResources().getText(R.string.d);
                }else if(c.calcularIMC() > 35 && c.calcularIMC() <= 40){
                    s+="\n"+getResources().getText(R.string.e);
                }else if(c.calcularIMC() > 40 && c.calcularIMC() <= 50){
                    s+= "\n"+getResources().getText(R.string.f);
                }else{
                    s+= "\n"+getResources().getText(R.string.g);
                }

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.alert_titulo));
                msg.setMessage(s+"\n");
                msg.setIcon(R.mipmap.ic_launcher);
                msg.setNeutralButton(getResources().getText(R.string.alert_botao),null);
                msg.show();

                etNome.setText(null);
                etPeso.setText(null);
                etMetro.setText(null);
                etCentimetro.setText(null);
            }
        });

    }
}
