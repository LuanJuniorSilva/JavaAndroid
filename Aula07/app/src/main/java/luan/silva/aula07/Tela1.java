package luan.silva.aula07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela1 extends AppCompatActivity {

    //widgets
    private Button btnAbrir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Referencia
        btnAbrir = (Button) findViewById(R.id.btn_abrir);

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela1.this, Tela2.class);//comando para abri uma nova tela
                startActivity(it);//comando para startar a nova tela
                finish();//comando para
            }
        });
    }//fecha onCreate
}//fecha classe
