package thiagocury.eti.br.aula11intentobjeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        if(getIntent().getSerializableExtra("cliente")!=null){

            Cliente cli = (Cliente)
               getIntent().getSerializableExtra("cliente");
            Toast.makeText(
                    getBaseContext(),
                    cli.toString(),
                    Toast.LENGTH_LONG).show();
        }//fecha cliente
    }
}
