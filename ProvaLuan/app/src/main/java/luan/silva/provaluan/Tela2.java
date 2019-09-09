package luan.silva.provaluan;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import luan.silva.provaluan.modelo.Meta;

public class Tela2 extends AppCompatActivity {

    //widgets
    private EditText etNomeMeta;
    private EditText etPesoAtual;
    private EditText etPesoDesejado;
    private RadioGroup gpSexo;
    private RadioButton rdMasc;
    private RadioButton rdFemi;
    private CheckBox cbManha;
    private CheckBox cbTarde;
    private CheckBox cbNoite;
    private Spinner opt;
    private Button btnCadastrar;


    //object
    private Meta meta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //references
        etNomeMeta = (EditText) findViewById(R.id.tela2_nome);
        etPesoAtual = (EditText) findViewById(R.id.tela2_peso);
        etPesoDesejado = (EditText) findViewById(R.id.tela2_pedo_desejado);
        gpSexo = (RadioGroup) findViewById(R.id.gpsexo);
        rdMasc = (RadioButton) findViewById(R.id.tela2_masc);
        rdFemi = (RadioButton) findViewById(R.id.tela2_femi);
        cbManha = (CheckBox) findViewById(R.id.tela2_manha);
        cbTarde = (CheckBox) findViewById(R.id.tela2_tarde);
        cbNoite = (CheckBox) findViewById(R.id.tela2_noite);
        opt = (Spinner) findViewById(R.id.sp_opt);
        btnCadastrar = (Button) findViewById(R.id.tela1_btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),"pegou",Toast.LENGTH_LONG).show();

                meta = new Meta();
                meta.setNomeMeta(etNomeMeta.getText().toString());
                meta.setPedoAtual(Double.parseDouble(etPesoAtual.getText().toString()));
                meta.setPesoDesejado(Double.parseDouble(etPesoDesejado.getText().toString()));

                if(gpSexo.getCheckedRadioButtonId() == rdMasc.getId()){
                    meta.setSexo(rdMasc.getText().toString());
                }else{
                    meta.setSexo(rdFemi.getText().toString());
                }

                ArrayList<String>opts = new ArrayList<String>();

                if(cbManha.isChecked()){
                    opts.add(cbManha.getText().toString());
                }
                if(cbTarde.isChecked()){
                    opts.add(cbTarde.getText().toString());
                }
                if(cbNoite.isChecked()){
                    opts.add(cbNoite.getText().toString());
                }
                meta.setTurno(opts);

                meta.setOpcao(opt.getSelectedItem().toString());

                String s = getResources().getText(R.string.nome)+": "+meta.getNomeMeta()
                        +"\n"+getResources().getText(R.string.peso_atual)+": "+meta.getPedoAtual()
                        +"\n"+getResources().getText(R.string.peso_desejado)+": "+meta.getPesoDesejado()
                        +"\n"+getResources().getText(R.string.sexo)+": "+meta.getSexo()
                        +"\n"+getResources().getText(R.string.turno)+": "+meta.getTurno()
                        +"\n"+getResources().getText(R.string.opcao)+": "+meta.getOpcao();

                if(meta.getOpcao().equalsIgnoreCase("Leve")){
                    s  += "\n"+getResources().getText(R.string.leve);;
                }else if(meta.getOpcao().equalsIgnoreCase("Intenso")){
                    s  += "\n"+getResources().getText(R.string.intenso);;
                }else{
                    s  += "\n"+getResources().getText(R.string.moderado);;
                }



                AlertDialog.Builder msg = new AlertDialog.Builder(Tela2.this);
                msg.setTitle("titulo da tela");
                msg.setMessage(s+"\n");
                msg.setIcon(R.mipmap.ic_launcher);
                msg.setNeutralButton("OK",null);
                msg.show();




            }//close onClick
        });//close setOnClickListener






    }//close onCreate
}//close class
