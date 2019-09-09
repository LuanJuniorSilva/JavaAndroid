package luan.silva.provaluan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela1 extends AppCompatActivity {

    private Button btnIniciarMeta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //references
        btnIniciarMeta = (Button) findViewById(R.id.btn_iniciar_meta);

        //
        btnIniciarMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela1.this, Tela2.class);
                startActivity(it);
            }
        });//close OnClick




    }//close OnCreate
}//close class
