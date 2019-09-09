package alicia.tanski.aula8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaCadastro extends AppCompatActivity {

    //widgets
    private EditText etNome;
    private RadioGroup grupoSexo;
    private RadioButton rdFeminino;
    private RadioButton rdMasculino;
    private Button btnCadastrar;

    //widgets check
    private CheckBox chVisa;
    private CheckBox chMaster;

    //obj
    private Cliente cli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        //referencias
        etNome = (EditText) findViewById(R.id.tc_et_nome);
        grupoSexo = (RadioGroup) findViewById(R.id.tc_grupo_sexo);
        rdFeminino = (RadioButton) findViewById(R.id.tc_rd_feminino);
        rdMasculino = (RadioButton) findViewById(R.id.tc_rd_masculino);
        btnCadastrar = (Button) findViewById(R.id.tc_btn_cadastrar);
        chVisa = (CheckBox) findViewById(R.id.tc_ch_visa);
        chMaster = (CheckBox) findViewById(R.id.tc_ch_master);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //instanciando

                cli = new Cliente();
                cli.setNome(etNome.getText().toString());

                if (grupoSexo.getCheckedRadioButtonId() == rdMasculino.getId()){
                    cli.setSexo(rdMasculino.getText().toString());
                }else {
                    cli.setSexo(rdFeminino.getText().toString());
                }//fecha else

                //ArrayList check Box
                ArrayList<String> prefs = new ArrayList<String>();
                if (chVisa.isChecked()){
                    prefs.add(chVisa.getText().toString());
                }
                if (chMaster.isChecked()){
                    prefs.add(chMaster.getText().toString());
                }

                //nao esquecer essa budega

                cli.setPrefs(prefs);//enviando ArreyList para o objeto


                Toast.makeText(getBaseContext() , cli.toString() , Toast.LENGTH_LONG).show();


            }//fehca Onclick
        });//fecha listener


    }//fecha onCreate
}//fecha class