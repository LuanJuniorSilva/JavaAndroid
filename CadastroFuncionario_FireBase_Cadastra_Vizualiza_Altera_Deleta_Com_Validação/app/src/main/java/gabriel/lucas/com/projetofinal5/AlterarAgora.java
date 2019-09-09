package gabriel.lucas.com.projetofinal5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AlterarAgora extends AppCompatActivity {

//    private EditText tsNome;
    private TextView fixoNome;
    private EditText tsEndereco;
    private EditText tsFone;
    private EditText tsCpf;
    private EditText tsEmail;
    private Button tsBtnAlterar;
    private Button tsBtnVoltar;
    private Usuario u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_agora);

        setTitle("Alterar");
//        tsNome = (EditText) findViewById(R.id.alterar_nome);
        tsEndereco = (EditText) findViewById(R.id.alterar_endereco);
        tsFone = (EditText) findViewById(R.id.alterar_fone);
        tsCpf = (EditText) findViewById(R.id.alterar_cpf);
        tsEmail = (EditText) findViewById(R.id.alterar_email);
        tsBtnAlterar = (Button) findViewById(R.id.alterar_btn);
        tsBtnVoltar = (Button) findViewById(R.id.alterar_voltar);
        fixoNome = (TextView) findViewById(R.id.fixo_nome);
        //Firebase
        FirebaseApp.initializeApp(AlterarAgora.this);
        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference banco = db.getReference("usuarios");

        if(getIntent().getSerializableExtra("u") !=null){
            u = (Usuario) getIntent().getSerializableExtra("u");
//            tsNome.setText(u.getNome());
            fixoNome.setText(u.getNome());
            tsEndereco.setText(u.getEndereco());
            tsFone.setText(u.getFone());
            tsCpf.setText(u.getCpf());
            tsEmail.setText(u.getEmail());
        }

        tsBtnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!Validacao.testarEndereco(tsEndereco.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar Endereço",Toast.LENGTH_LONG).show();
                }else if(!Validacao.testarTelefone(tsFone.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar Telefone",Toast.LENGTH_LONG).show();
                }else if(!Validacao.testarCpf(tsCpf.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar CPF",Toast.LENGTH_LONG).show();
                }else if(!Validacao.testarEmail(tsEmail.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar Email",Toast.LENGTH_LONG).show();
                }else {

                    Usuario u2 = new Usuario();
                    u2.setNome(fixoNome.getText().toString());
                    u2.setEndereco(tsEndereco.getText().toString());
                    u2.setFone(tsFone.getText().toString());
                    u2.setCpf(tsCpf.getText().toString());
                    u2.setEmail(tsEmail.getText().toString());

                    banco.child(u.getChavao()).setValue(u2);

                    AlertDialog.Builder alterado = new AlertDialog.Builder(AlterarAgora.this);
                    alterado.setTitle("Funcionario " + u.getNome() + " alterado");
                    alterado.setMessage("Dados:" + u2.toString2());
                    alterado.setPositiveButton("Tela de Funcionarios", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent it = new Intent(AlterarAgora.this, TelaListView.class);
                            startActivity(it);
                            finish();
                        }
                    });
                    alterado.show();
                }
                }
        });

        tsBtnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AlterarAgora.this, TelaListView.class);
                startActivity(it);
                finish();
            }
        });
fixoNome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"Funcionario "+u.getNome(),Toast.LENGTH_LONG).show();
    }
});
tsEndereco.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"Endereço",Toast.LENGTH_SHORT).show();
    }
});
tsCpf.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"CPF",Toast.LENGTH_SHORT).show();
    }
});
tsFone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"Telefone",Toast.LENGTH_SHORT).show();
    }
});
tsEmail.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"Email",Toast.LENGTH_SHORT).show();
    }
});

    }//onCreate
}//class
