package thiagocury.eti.br.aula11intentretornando2tela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela2 extends AppCompatActivity {

    private EditText etNome;
    private Button btnOK;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        etNome = (EditText) findViewById(R.id.t2_et_nome);
        btnOK = (Button) findViewById(R.id.t2_btn_ok);
        btnCancelar = (Button) findViewById(R.id.t2_btn_cancelar);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.putExtra("nome",etNome.getText().toString());
                setResult(RESULT_OK, it);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}
