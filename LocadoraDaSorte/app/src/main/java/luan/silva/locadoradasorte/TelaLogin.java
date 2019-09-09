package luan.silva.locadoradasorte;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import luan.silva.locadoradasorte.modelo.Usuario;
import luan.silva.locadoradasorte.util.Validacao;

import static android.R.string.cancel;

public class TelaLogin extends AppCompatActivity {

    private EditText etEmail;
    private EditText etSenha;
    private Button btnLogar;
    private TextView btnCriarConta;
    private ProgressBar progress;

    //Firebase autenticação
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //TAG para LOG
    private static final String TAG = "Teste Login Firebase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //Referencias
        etEmail = (EditText) findViewById(R.id.tl_et_email);
        etSenha = (EditText) findViewById(R.id.tl_et_senha);
        btnLogar = (Button) findViewById(R.id.tl_btn_logar);
        btnCriarConta = (TextView) findViewById(R.id.tl_btn_criar_conta);
        progress = (ProgressBar) findViewById(R.id.tl_progress);

        //Pegando Referencia Firebase
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in: LOGADO POHA" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out DESLOGOU POHA");
                }
                // ...
            }
        };
        try {
        //Clique do botão Logar
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Validacao.testarEmail(etEmail.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaLogin.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("Email INVALIDO");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();


                } else if (!Validacao.testarSenha(etSenha.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaLogin.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("Senha INVALIDA");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();
                }else{

                //Iniciando progress
                progress.setVisibility(View.VISIBLE);

                //Criando objeto usuario
                Usuario u = new Usuario();
                u.setLogin(etEmail.getText().toString());
                u.setSenha(etSenha.getText().toString());

                mAuth.signInWithEmailAndPassword(u.getLogin(), u.getSenha())
                        .addOnCompleteListener(TelaLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                if (!task.isSuccessful()) {
                                    Toast.makeText(
                                            getBaseContext(),
                                            "Erro ao logar!",
                                            Toast.LENGTH_SHORT).show();
                                } else {

                                    //Enviando para a tela Inicial após logar
                                    Intent it = new Intent(TelaLogin.this, TelaInicial.class);
                                    startActivity(it);
                                    finish();

                                    Toast.makeText(
                                            getBaseContext(),
                                            "Você está logado!",
                                            Toast.LENGTH_SHORT).show();
                                }//fecha if

                                //Removendo progress
                                progress.setVisibility(View.INVISIBLE);
                            }//fecha onComplete
                        });//fecha listener
            }//fecha onClick

        }//fecha else de vaidacao
        });//fecha listener onclick

            btnCriarConta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent itt = new Intent(TelaLogin.this,TelaCadastroCliente.class);
                    startActivity(itt);
                }
            });

        //Clique do botão CriarConta
            /*
        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Iniciando progress
                progress.setVisibility(View.VISIBLE);

                //Criando objeto usuario
                Usuario u = new Usuario();
                u.setLogin(etEmail.getText().toString());
                u.setSenha(etSenha.getText().toString());

                mAuth.createUserWithEmailAndPassword(u.getLogin(), u.getSenha())
                        .addOnCompleteListener(TelaLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

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


                                            //dados...
                                            u.setemail
                                            u.setrg
                                            u.setasdfasd

                                            Database db
                                            db.push().setValue(u);
                                }
                            }//fecha onComplete
                        });//fecha mAuth

                //Removendo progress
                progress.setVisibility(View.INVISIBLE);

            }//fecha onclick
        });//fecha listener
*/

        }catch (Exception e){
            Toast.makeText(getBaseContext(),"preencha todos os campos",Toast.LENGTH_LONG).show();
        }
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
}//fecha classe