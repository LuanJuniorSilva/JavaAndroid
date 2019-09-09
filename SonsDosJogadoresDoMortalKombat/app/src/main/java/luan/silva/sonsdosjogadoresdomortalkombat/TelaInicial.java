package luan.silva.sonsdosjogadoresdomortalkombat;

import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    //widgets
    private Button baraka;
    private Button jax;
    private Button johnnycage;
    private Button kitana;
    private Button kunglao;
    private Button liukang;
    private Button milena;
    private Button raiden;
    private Button scorpion;
    private Button subzero;
    private Button repitile;
    private Button shangtsung;

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        baraka = (Button) findViewById(R.id.baraka);
        jax = (Button) findViewById(R.id.jax);
        johnnycage = (Button) findViewById(R.id.johnnycage);
        kitana = (Button) findViewById(R.id.kitana);
        kunglao = (Button) findViewById(R.id.kunglao);
        liukang = (Button) findViewById(R.id.liukang);
        milena = (Button) findViewById(R.id.milena);
        raiden = (Button) findViewById(R.id.raiden);
        scorpion = (Button) findViewById(R.id.scorpion);
        subzero = (Button) findViewById(R.id.subzero);
        repitile = (Button) findViewById(R.id.repitile);
        shangtsung = (Button) findViewById(R.id.shangtsung);

       baraka.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.baraka),Toast.LENGTH_SHORT).show();
               play(view,R.raw.baraka);
           }//fim do onclick
       });//fim do onclicklistener

        baraka.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.baraka));
                msg.setMessage(getResources().getText(R.string.h_baraka));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener

        jax.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.jax),Toast.LENGTH_SHORT).show();
               play(view,R.raw.jax);
           }//fim do onclick
       });//fim do onclicklistener

        jax.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.jax));
                msg.setMessage(getResources().getText(R.string.h_jax));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener

        johnnycage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.johnnycage),Toast.LENGTH_SHORT).show();
               play(view,R.raw.cage);
           }//fim do onclick
       });//fim do onclicklistener

        johnnycage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.johnnycage));
                msg.setMessage(getResources().getText(R.string.h_johnnycage));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener


        kitana.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.kitana),Toast.LENGTH_SHORT).show();
               play(view,R.raw.kitana);
           }//fim do onclick
       });//fim do onclicklistener

        kitana.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.kitana));
                msg.setMessage(getResources().getText(R.string.h_kitana));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener


        kunglao.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.kunglao),Toast.LENGTH_SHORT).show();
               play(view,R.raw.kunglao);
           }//fim do onclick
       });//fim do onclicklistener

        kunglao.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.kunglao));
                msg.setMessage(getResources().getText(R.string.h_kunglao));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener

        liukang.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.liukang),Toast.LENGTH_SHORT).show();
               play(view,R.raw.liukang);
           }//fim do onclick
       });//fim do onclicklistener

        liukang.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.liukang));
                msg.setMessage(getResources().getText(R.string.h_liukang));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener


        milena.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.milena),Toast.LENGTH_SHORT).show();
               play(view,R.raw.mileena);
           }//fim do onclick
       });//fim do onclicklistener

        milena.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.milena));
                msg.setMessage(getResources().getText(R.string.h_milena));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener

        raiden.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.raiden),Toast.LENGTH_SHORT).show();
               play(view,R.raw.raiden);
           }//fim do onclick
       });//fim do onclicklistener

        raiden.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.raiden));
                msg.setMessage(getResources().getText(R.string.h_raiden));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener


        scorpion.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.scorpion),Toast.LENGTH_SHORT).show();
               play(view,R.raw.scorp);
           }//fim do onclick
       });//fim do onclicklistener

        scorpion.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.scorpion));
                msg.setMessage(getResources().getText(R.string.h_scorpion));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener

        subzero.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.subzero),Toast.LENGTH_SHORT).show();
               play(view,R.raw.subzero);
           }//fim do onclick
       });//fim do onclicklistener

        subzero.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.subzero));
                msg.setMessage(getResources().getText(R.string.h_subzero));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener


        repitile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.repitile),Toast.LENGTH_SHORT).show();
               play(view,R.raw.reptile);
           }//fim do onclick
       });//fim do onclicklistener

        repitile.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.repitile));
                msg.setMessage(getResources().getText(R.string.h_repitile));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener

        shangtsung.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getBaseContext(),getResources().getText(R.string.shangtsung),Toast.LENGTH_SHORT).show();
               play(view,R.raw.shang);
           }//fim do onclick
       });//fim do onclicklistener

        shangtsung.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder msg = new AlertDialog.Builder(TelaInicial.this);
                msg.setTitle(getResources().getText(R.string.shangtsung));
                msg.setMessage(getResources().getText(R.string.h_shangtsung));
                msg.setNeutralButton(getResources().getText(R.string.msg),null);
                msg.show();

                return true;
            }//fim do onclicklong
        });//fim do onclicklonglistener



    }//fim do onCreate


    public void play(View v, int som){
        try {
            mp = MediaPlayer.create(getBaseContext(),som);
            mp.start();
        }catch (Exception e){
            mp.stop();
        }//fim do trycatch
    }//fim do metodo play

}//fim da classe
