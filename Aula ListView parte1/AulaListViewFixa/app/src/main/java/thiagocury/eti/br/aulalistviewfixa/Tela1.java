package thiagocury.eti.br.aulalistviewfixa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    //Widget
    private ListView lvClientes;
    //Adapter
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Referencias
        lvClientes=(ListView)findViewById(R.id.t1_lv_clientes);

        adapter = new ArrayAdapter<>(
              Tela1.this,
              android.R.layout.simple_list_item_1,
              getResources().getStringArray(R.array.lv_clientes));

        lvClientes.setAdapter(adapter);

        lvClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Buscando a posição selecionada
                Toast.makeText(
                        getBaseContext(),
                        "Nome escolhido: "+   //i é a posição escolhida
                        lvClientes.getItemAtPosition(i).toString(),
                        Toast.LENGTH_LONG).show();
            }//fecha onItemClick
        });//fecha onItemClick

        lvClientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(
                        getBaseContext(),
                        "Voce segurou o dedo e escolheu: "+i,
                        Toast.LENGTH_LONG).show();

                return true;
            }
        });

    }//fecha onCreate
}//fecha classe
