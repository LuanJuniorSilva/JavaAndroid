package thiagocury.eti.br.aula11intentretornando2tela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        btnOK = (Button) findViewById(R.id.t1_btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela1.this, Tela2.class);
                //startActivity(it);
                startActivityForResult(it,2);
            }
        });
    }//fecha onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2) {//testando qual activity retornou
            if(resultCode == RESULT_OK){
                String nome = data.getStringExtra("nome").toString();
                Toast.makeText(getBaseContext(),"Oi "+nome,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getBaseContext(),"Voce cancelou",Toast.LENGTH_LONG).show();
            }
        }
    }
}//fecha classe
