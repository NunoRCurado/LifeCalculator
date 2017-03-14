package com.example.nuno.dayevaluation;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Nuno on 08-Mar-17.
 */

public class AdapterMeses extends BaseAdapter {


    private int[]mediaCores;
    private String[]listMeses;
    private Context c;
    private TextView buttonMes;


    public AdapterMeses(Context ctx, String[] listMeses, int[]mediaCores) {

        super();
        this.listMeses = listMeses;
        this.c = ctx;
        this.mediaCores = mediaCores;


    }

    @Override
    public int getCount() {
        return listMeses.length;
    }

    @Override
    public Object getItem(int position) {
        return listMeses[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model_mes, null);
        }

        buttonMes =  (TextView) convertView.findViewById(R.id.grid_item);

        if(mediaCores[position] == 0){
            buttonMes.setBackgroundColor(ContextCompat.getColor(c, R.color.red));

        }
       else if(mediaCores[position] == 1){
            buttonMes.setBackgroundColor(ContextCompat.getColor(c, R.color.yellow));

        }
        else
            buttonMes.setBackgroundColor(ContextCompat.getColor(c, R.color.green));
            buttonMes.setText(listMeses[position]);

        return convertView;
    }



}
