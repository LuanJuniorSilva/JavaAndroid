package luan.silva.exercicioaula09;

import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class TelaInicial extends AppCompatActivity {

    //widgets
    private EditText etNome;
    private EditText etCidade;
    private EditText etBairro;
    private EditText etRua;

    private RadioGroup gpSexo;
    private RadioButton masc;
    private RadioButton femi;

    private Spinner estado;
    private Spinner estadoCivil;

    private Button btnSalvar;

    //objeto

    private Cliente cliente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        //referencias

        etNome = (EditText) findViewById(R.id.ti_nome);
        etCidade = (EditText) findViewById(R.id.ti_cidade);
        etBairro = (EditText) findViewById(R.id.ti_bairro);
        etRua = (EditText) findViewById(R.id.ti_rua);

        gpSexo = (RadioGroup) findViewById(R.id.gp_sexo);
        masc = (RadioButton) findViewById(R.id.masc);
        femi = (RadioButton) findViewById(R.id.femi);

        estado = (Spinner) findViewById(R.id.estado);
        estadoCivil = (Spinner) findViewById(R.id.estado_civil);

        btnSalvar = (Button) findViewById(R.id.btn_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (estado.getSelectedItem().toString().equalsIgnoreCase("Seleiocne") || estadoCivil.getSelectedItem().toString().equalsIgnoreCase("Seleiocne")) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                    msg.setTitle("Erro");
                    msg.setMessage("Preencha todos os campos corretamente");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.show();
                } else {
                    cliente = new Cliente();
                    cliente.setNome(etNome.getText().toString());
                    cliente.setCidade(etCidade.getText().toString());
                    cliente.setBairro(etBairro.getText().toString());
                    cliente.setRua(etRua.getText().toString());

                    if (gpSexo.getCheckedRadioButtonId() == masc.getId()) {
                        cliente.setSexo(masc.getText().toString());
                    } else {
                        cliente.setSexo(femi.getText().toString());
                    }

                    cliente.setEstadoCivil(estadoCivil.getSelectedItem().toString());
                    cliente.setEstado(estado.getSelectedItem().toString());

                    Toast.makeText(getBaseContext(), cliente.toString(), Toast.LENGTH_LONG).show();

                }

            }//fecha onClick
        });//fecha Onclick Listener


    }//fecha onCreate


}//fecha classe
