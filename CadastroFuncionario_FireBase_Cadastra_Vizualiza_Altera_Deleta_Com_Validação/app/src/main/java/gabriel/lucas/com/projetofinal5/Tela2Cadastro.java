package gabriel.lucas.com.projetofinal5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tela2Cadastro extends AppCompatActivity {

    //wgts
    private EditText tsNome;
    private EditText tsEndereco;
    private EditText tsFone;
    private EditText tsCpf;
    private EditText tsEmail;
    private Button tsBtn;
//    private Button teste;
    private RelativeLayout relativeLayout;

    //objeto
    private Usuario u;

    //array e adapter
    private ArrayAdapter<Usuario> usuAdapter;
    private ArrayList<Usuario> usuarios;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_cadastro);
        //titulo da tela
        setTitle("Tela de Cadastro");

        //Ref
        tsNome = (EditText) findViewById(R.id.ts_nome);
        tsEndereco = (EditText) findViewById(R.id.ts_endereco);
        tsFone = (EditText) findViewById(R.id.ts_fone);
        tsCpf = (EditText) findViewById(R.id.ts_cpf);
        tsEmail = (EditText) findViewById(R.id.ts_email);
        tsBtn = (Button) findViewById(R.id.ts_btn);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_tela2_cadastro);
//teste = (Button) findViewById(R.id.fuck);
        //List e Adapter
        usuarios = new ArrayList<>();
        usuAdapter = new ArrayAdapter<Usuario>(Tela2Cadastro.this, android.R.layout.simple_list_item_1, usuarios);

        //god firebase
        FirebaseApp.initializeApp(Tela2Cadastro.this);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference banco = db.getReference("usuarios");

        //botão OnClickListener para cadastar o usuario e botar no banco

        tsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if(spSelect.getSelectedItem().toString().equalsIgnoreCase("Selecione")) {
//                    AlertDialog.Builder msg = new AlertDialog.Builder(Tela2.this);
//                    msg.setTitle("ERRO");
//                    msg.setMessage("Selecione um Tipo de treino!");
//                    msg.setIcon(R.mipmap.ic_launcher);
//                    msg.setNeutralButton("OK",null);
//                    msg.show();
//
//                }else{

                if(!Validacao.testarNome(tsNome.getText().toString())){
                    Toast.makeText(getBaseContext(), "Botar Nome",Toast.LENGTH_LONG).show();
                }else if(!Validacao.testarEndereco(tsEndereco.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar Endereço",Toast.LENGTH_LONG).show();
                }else if(!Validacao.testarTelefone(tsFone.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar Telefone",Toast.LENGTH_LONG).show();
                }else if(!Validacao.testarCpf(tsCpf.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar CPF",Toast.LENGTH_LONG).show();
                }else if(!Validacao.testarEmail(tsEmail.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Botar Email",Toast.LENGTH_LONG).show();
                }else{
                    //pegando os dados do Usuario
                    u = new Usuario();
                    u.setNome(tsNome.getText().toString());
                    u.setEndereco(tsEndereco.getText().toString());
                    u.setFone(tsFone.getText().toString());
                    u.setCpf(tsCpf.getText().toString());
                    u.setEmail(tsEmail.getText().toString());

                    //botando no banco
                    banco.push().setValue(u);

                    //limpar os usuarios
                    usuarios.clear();
                    AlertDialog.Builder msg = new AlertDialog.Builder(Tela2Cadastro.this);
                    msg.setTitle("Funcionario " + u.getNome() + " Cadastrado");
                    msg.setMessage("Seus dados:" + u.toString2());
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("Funcionarios Cadastrados", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent it = new Intent(Tela2Cadastro.this, TelaListView.class);
                            startActivity(it);
                            finish();
                        }//fecha onClick
                    });//fecha listener
                    msg.setPositiveButton("Tela Inicial", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent it = new Intent(Tela2Cadastro.this, TelaPrincipalBotaoLocais.class);
                            startActivity(it);
                            finish();
                        }//fecha onClick
                    });//fecha listener
                    msg.show();
                }
            }//feca onClick
        });//fecha Listener do onClick

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela2Cadastro.this, TelaPrincipalBotaoLocais.class);
                startActivity(it);
                finish();
            }
        });

//        teste.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it = new Intent(Tela2Cadastro.this, AlterarAgora.class);
//                startActivity(it);
//            }
//        });

    }//fecha onCreate
}//fecha class
