package luan.silva.aulalistviewbaseadaptercustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tela1 extends AppCompatActivity {
    //widgets
    private EditText etNome;
    private EditText etIdade;
    private EditText etSexo;
    private ListView lvPessoas;
    private Button btnOk;
    //objeto
    private Pessoa p;
    //ArrayList e Adapter
    private ArrayList<Pessoa> pessoas;
    private  PessoaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //referencias
        etNome = (EditText) findViewById(R.id.t1_et_nome);
        etIdade = (EditText) findViewById(R.id.t1_et_idade);
        etSexo = (EditText) findViewById(R.id.t1_et_sexo);
        lvPessoas = (ListView) findViewById(R.id.t1_lv_pessoas);
        btnOk = (Button) findViewById(R.id.t1_btn_ok);
        //ArrayAdapter
        pessoas = new ArrayList<Pessoa>();
        adapter = new PessoaAdapter(Tela1.this,pessoas);
        lvPessoas.setAdapter(adapter);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setSexo(etSexo.getText().toString());
                p.setIdade(Integer.parseInt(etIdade.getText().toString()));
                pessoas.add(p);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(),"Cadastro Ok",Toast.LENGTH_LONG).show();
            }//fecha onclick
        });//fecha onCreate

    }
}
