package thiagocury.eti.br.aula11intentobjeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private EditText etIdade;
    private Button btnOK;
    //Objeto
    private Cliente cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Referencias
        etNome = (EditText) findViewById(R.id.t1_et_nome);
        etIdade = (EditText) findViewById(R.id.t1_et_idade);
        btnOK = (Button) findViewById(R.id.t1_btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Criar o objeto
                cli = new Cliente();
                cli.setNome(etNome.getText().toString());
                cli.setIdade(
                        Integer.parseInt(
                                etIdade.getText().toString()));

                Intent it = new Intent(Tela1.this,Tela2.class);
                it.putExtra("cliente",cli);
                startActivity(it);
            }
        });
    }
}
