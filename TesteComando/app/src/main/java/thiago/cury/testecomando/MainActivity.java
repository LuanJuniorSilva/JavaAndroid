package thiago.cury.testecomando;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText etComando;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refe
        btnOK = (Button) findViewById(R.id.btn_ok);
        etComando = (EditText) findViewById(R.id.editText);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process process = Runtime.getRuntime().exec(etComando.getText().toString());
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    int read;
                    char[] buffer = new char[4096];
                    StringBuffer output = new StringBuffer();
                    while ((read = reader.read(buffer)) > 0) {
                        output.append(buffer, 0, read);
                    }
                    reader.close();

                    process.waitFor();

                    AlertDialog.Builder msg =new AlertDialog.Builder(MainActivity.this);
                    msg.setTitle("Relatorio");
                    msg.setMessage("Será: "+output.toString());
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK",null);
                    msg.show();
                }catch (IOException ioe){
                    Log.d("teste",ioe.getMessage());
                }catch (InterruptedException ie){
                    Log.d("teste",ie.getMessage());
                }
            }
        });
    }
}
