package luan.silva.aulalistviewarrayadaptercustom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alunos on 19/12/2016.
 */

public class PessoaAdapter extends ArrayAdapter<Pessoa>{
    private Context context;
    private ArrayList<Pessoa>pessoas;

    public PessoaAdapter(Context context, ArrayList pessoas) {
        super(context, 0,pessoas);

        this.context = context;
        this.pessoas = pessoas;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.linha_pessoa,null);
        }//fecha if

        Pessoa p = pessoas.get(position);

        //TextView nome
        TextView tvNome = (TextView) convertView.findViewById(R.id.lp_tv_nome);
        tvNome.setText(p.getNome());
        //TextView idade
        TextView tvidade = (TextView) convertView.findViewById(R.id.lp_tv_idade);
        tvidade.setText(String.valueOf(p.getIdade()));
        //TextView sexo
        TextView tvSexo = (TextView) convertView.findViewById(R.id.lp_tv_sexo);
        tvSexo.setText(p.getSexo());

        ImageView lvSexo = (ImageView) convertView.findViewById(R.id.lp_img_sexo);

        if(p.getSexo().equalsIgnoreCase("Masculino")){
            lvSexo.setImageResource(R.drawable.man);
        }else if(p.getSexo().equalsIgnoreCase("Feminino")){
            lvSexo.setImageResource(R.drawable.woman);
        }else{
            lvSexo.setImageResource(R.mipmap.ic_launcher);
        }

        return convertView;
    }


}//fecha classe
