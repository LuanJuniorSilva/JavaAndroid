package thiagocury.eti.br.aula11intentdiversos;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {

    private EditText etDigite;
    private Button btnOK;
    private Button btnInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Referencias
        etDigite = (EditText) findViewById(R.id.et_digite);
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnInternet = (Button) findViewById(R.id.btn_internet);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chamar o discador
                String texto = etDigite.getText().toString();
                Uri uri = Uri.parse("tel:"+texto);
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
            }
        });

        btnInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrir Browser
                String texto = etDigite.getText().toString();
                Uri uri = Uri.parse("http://"+texto);
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });
    }//fecha onCreate
}//fecha classe
