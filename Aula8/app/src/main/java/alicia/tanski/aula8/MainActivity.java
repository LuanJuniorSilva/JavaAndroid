package alicia.tanski.aula8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //widgets
    private Button btn_abrir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referencias
        btn_abrir = (Button) findViewById(R.id.btn_abrir);

        btn_abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, TelaCadastro.class);
                startActivity(it);

            }//fecha onClick
        });//fecha listener

    }//feccha //oncreate
}//fecha class
