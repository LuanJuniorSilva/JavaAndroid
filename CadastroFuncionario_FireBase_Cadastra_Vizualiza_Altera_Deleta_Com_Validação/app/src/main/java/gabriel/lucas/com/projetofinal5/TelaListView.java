package gabriel.lucas.com.projetofinal5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;

public class TelaListView extends AppCompatActivity {

    //Wgts
    private ListView telaLv;
    private Button tvlNewFuncionario;
    private TextView tlvTitulo;
    private RelativeLayout relativeLayout;

    //ArrayAdapter e ArrayList
    private ArrayAdapter<Usuario> usuAdapter;
    private ArrayList<Usuario> usuarios;

    //Guardar posição selecionada
//    private int posicaoSelec = -1;

    //Objeto
    private Usuario u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_list_view);
        //Titulo da tela
        setTitle("Lista de Funcionarios");

        //Ref
        telaLv = (ListView) findViewById(R.id.tela_lv);
        tvlNewFuncionario = (Button) findViewById(R.id.tvl_newfunc);
        tlvTitulo = (TextView) findViewById(R.id.tlv_titulo);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_tela_list_view);

        //ArrayList e ArrayAdapter
        usuarios = new ArrayList<>();
        usuAdapter = new ArrayAdapter<Usuario>(TelaListView.this, android.R.layout.simple_list_item_1, usuarios);

        //botando adapter
        telaLv.setAdapter(usuAdapter);

        //fodendo firebase
        FirebaseApp.initializeApp(this);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference banco = db.getReference("usuarios");

        //pegando todos os usuarios do banco e "gospindo" no ListView
        banco.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot data: dataSnapshot.getChildren()){

                        //buscando usuarios no banco
                        Usuario u = data.getValue(Usuario.class);
                        //pegando key
                        u.setChavao(data.getKey());
                        //add usuarios na ListView
                        usuarios.add(u);

                }//fecha for

                //atualizando o Adapter
                usuAdapter.notifyDataSetChanged();

            }//fecha DataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {
                    //vazio
            }//fecha onCancelled
        });//fecha Listener

        //OnITEMClick para mostrar todos os detalhes do usuario
        telaLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

             /*   //setando posição
                posicaoSelec = position;

                //puxando usuario                     //pegando posição escolhida
                Usuario u = (Usuario) telaLv.getItemAtPosition(posicaoSelec);
*/

                Usuario u = usuarios.get(position);


                //guspindo dados no AlertDialog
                AlertDialog.Builder msg = new AlertDialog.Builder(TelaListView.this);
                msg.setTitle("Funcionario "+u.getNome());
                msg.setMessage("Dados Completos:"+u.toString2());
                msg.setIcon(R.mipmap.ic_launcher);
                msg.setPositiveButton("Editar usuario", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Usuario u = usuarios.get(position);

                        Intent it = new Intent(TelaListView.this, AlterarAgora.class);
                        it.putExtra("u",u);
                        startActivity(it);

                    }
                });
                msg.setNeutralButton("Tela Inicial", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent it = new Intent(TelaListView.this, TelaPrincipalBotaoLocais.class);
                        startActivity(it);
                        finish();

                    }//fecha onClicl
                });//fecha Listener
                msg.show();

            }//fecha onItem
        });//fecha Listener


        telaLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                       final int posicaoSelec = position;

//                puxando e pegando posição do usuario
                        Usuario u = usuarios.get(posicaoSelec);
//                removendo do banco/
                        banco.child(u.getChavao()).removeValue();
//                removendo da listview
                        usuarios.remove(position);
                        usuarios.clear();
//                notificando o adapter
                        usuAdapter.notifyDataSetChanged();
                        Toast.makeText(getBaseContext(), "Funcionario removido", Toast.LENGTH_LONG).show();

        return true;
    }
});

        tvlNewFuncionario.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent it = new Intent(TelaListView.this, Tela2Cadastro.class);
        startActivity(it);
        finish();
        }
        });

        tlvTitulo.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Toast.makeText(getBaseContext(), "Projeto criado por Rymsza e Wottrich", Toast.LENGTH_LONG).show();
        }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaListView.this, TelaPrincipalBotaoLocais.class);
                startActivity(it);
                finish();
            }
        });


    }//fecha onCreate
}//fecha class
