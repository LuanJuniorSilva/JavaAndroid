package luan.silva.locadoradasorte;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import luan.silva.locadoradasorte.modelo.Usuario;
import luan.silva.locadoradasorte.util.Validacao;

public class TelaCadastroCliente extends AppCompatActivity {

    //widgets
    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etData;
    private EditText etTelefone;
    private EditText etCpf;
    private RadioGroup rdsexo;
    private RadioButton rdmasc;
    private RadioButton rdfemi;
    private Button btnOk;

    //Objeto
    private Usuario u;

    //Firebase autenticação
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //referencias

        etNome = (EditText) findViewById(R.id.frm_nome);
        etEmail = (EditText) findViewById(R.id.frm_email);
        etSenha = (EditText) findViewById(R.id.frm_senha);
        etTelefone = (EditText) findViewById(R.id.frm_tel);
        rdsexo = (RadioGroup) findViewById(R.id.rd_sexo);
        etCpf = (EditText) findViewById(R.id.frm_cpf);
        etData = (EditText) findViewById(R.id.frm_data);
        rdmasc = (RadioButton) findViewById(R.id.rd_masc);
        rdfemi = (RadioButton) findViewById(R.id.rd_femi);
        btnOk = (Button) findViewById(R.id.cadastrar_usuario);

        //FIREBASE

        FirebaseApp.initializeApp(TelaCadastroCliente.this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference db = database.getReference("clientes");

        //Pegando Referencia Firebase
        mAuth = FirebaseAuth.getInstance();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Validacao.testarNome(etNome.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastroCliente.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("Nome INVALIDO");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();

                } else if (!Validacao.testarEmail(etEmail.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastroCliente.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("Email INVALIDO");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();
                } else if (!Validacao.testarSenha(etSenha.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastroCliente.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("Senha INVALIDA");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();
                }else if (!Validacao.testtarData(etData.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastroCliente.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("data INVALIDA");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();
                }else if (!Validacao.testarTelefone(etTelefone.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastroCliente.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("telefone INVALIDO");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();
                }else if (!Validacao.testarCpf(etCpf.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastroCliente.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("CPF INVALIDO");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();
                }else{

                u = new Usuario();
                u.setNome(etNome.getText().toString());
                u.setEmail(etEmail.getText().toString());
                u.setSenha(etSenha.getText().toString());
                u.setTelefone(etTelefone.getText().toString());
                u.setData(etData.getText().toString());
                u.setCpf(etCpf.getText().toString());
                if (rdsexo.getCheckedRadioButtonId() == rdmasc.getId()) {
                    u.setSexo(rdmasc.getText().toString());
                } else {
                    u.setSexo(rdfemi.getText().toString());
                }

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastroCliente.this);
                msg.setTitle("Informação Importante");
                msg.setMessage("Aqui estão teus teus dados ..." + u.toString());
                msg.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        mAuth.createUserWithEmailAndPassword(u.getEmail(), u.getSenha())
                                .addOnCompleteListener(TelaCadastroCliente.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        //  Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                        if (!task.isSuccessful()) {
                                            Toast.makeText(
                                                    getBaseContext(),
                                                    "Erro ao criar conta!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(
                                                    getBaseContext(),
                                                    "Conta criada com sucesso!",
                                                    Toast.LENGTH_SHORT).show();

                                        db.push().setValue(u);

                                            Intent entrarParaPagina = new Intent(TelaCadastroCliente.this,TelaInicial.class);
                                            startActivity(entrarParaPagina);
                                    }
                                }//fecha onComplete
                            });//fecha mAuth

                    }//fecha onClick
                });//fecha onClickListener

                msg.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {


                    Toast.makeText(getBaseContext(),"Operação Cancelada com Sucesso!",Toast.LENGTH_SHORT).show();
                }
            });
                    msg.show();

            }
            }//fecha onclick
        });//fecha setonclicklistener

    }//fecha onCreate

    @Override
    protected void onStart() {
        super.onStart();
        //Inserindo o Listener no onStart
        //mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Removendo o Listener no onStop
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }//fecha onStop

    private void criarConta(){
    }

    private void logar(){
    }

    private void deslogar(){
    }

}
