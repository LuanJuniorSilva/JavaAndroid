package luan.silva.projetodeaula08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaInicial extends AppCompatActivity {

    //widgets
    private EditText etNome;
    private RadioGroup grSexo;
    private RadioButton rdMasculino;
    private RadioButton rdFeminino;


    //widgets check
    private CheckBox php;
    private CheckBox asp;
    private CheckBox java;
    private CheckBox delphi;
    private Button btnComprar;

    //obj
    private  Produto p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        //referencias
        etNome = (EditText) findViewById(R.id.nome);
        grSexo = (RadioGroup) findViewById(R.id.tc_grupo_sexo);

        rdMasculino = (RadioButton) findViewById(R.id.tc_rd_masculino);
        rdFeminino = (RadioButton) findViewById(R.id.tc_rd_feminino);
        php  = (CheckBox) findViewById(R.id.php);
        asp  = (CheckBox) findViewById(R.id.asp);
        java  = (CheckBox) findViewById(R.id.java);
        delphi  = (CheckBox) findViewById(R.id.delphi);

        btnComprar = (Button) findViewById(R.id.comprar);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = new Produto();
                p.setNome(etNome.getText().toString());

                if (grSexo.getCheckedRadioButtonId() == rdMasculino.getId()){
                    p.setSexo(rdMasculino.getText().toString());
                }else {
                    p.setSexo(rdFeminino.getText().toString());
                }//fecha else

                //ArrayList check Box
                ArrayList<String> cursos = new ArrayList<String>();
                if(php.isChecked()){
                    cursos.add(php.getText().toString());
                }
                if(asp.isChecked()){
                    cursos.add(asp.getText().toString());
                }
                if(java.isChecked()){
                    cursos.add(java.getText().toString());
                }
                if(delphi.isChecked()){
                    cursos.add(delphi.getText().toString());
                }

                p.setCursos(cursos);

                Toast.makeText(getBaseContext(),p.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }
}
