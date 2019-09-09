package gabriel.lucas.com.projetofinal5;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class TelaPrincipalBotaoLocais extends AppCompatActivity {

    //wgts
    private Button tpBtn;
    private Button tpBtnPesq;
    private TextView tpTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_botao_locais);

        //botando o titulo da tela
        setTitle("Tela Inicial");

        //Ref
        tpBtn = (Button) findViewById(R.id.tp_btn);
        tpBtnPesq = (Button) findViewById(R.id.tp_btn_cadastrados);
        tpTitulo = (TextView) findViewById(R.id.tp_titulo);

        tpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaPrincipalBotaoLocais.this, Tela2Cadastro.class);
                startActivity(it);
            }//fecha onClick
        });//fecha Listener

       tpBtnPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaPrincipalBotaoLocais.this, TelaListView.class);
                startActivity(it);
            }//fecha onClick
        });//fecha Listener

        tpTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Criado por Wotrich e Rymsza",Toast.LENGTH_LONG).show();
            }
        });


    }//fecha onCreate
}//fecha class
