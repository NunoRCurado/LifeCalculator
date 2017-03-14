package com.example.nuno.dayevaluation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Nuno on 09-Mar-17.
 */

public class FragmentoMenu extends Fragment {

    private Button buttonData;
    private ImageView happyImageView;
    private ImageView neutralImageView;
    private ImageView sadImageView;
    private FragmentoMeses fragmentoMeses;
    private Auxiliar auxiliar;



    private Button teste;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
            try {
                auxiliar = (Auxiliar) activity;
            } catch (ClassCastException castException) {
                /** The activity does not implement the listener. **/
            }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.menu_principal,container, false);
        alocarUI(v);

        fragmentoMeses = new FragmentoMeses();

     /*   teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auxiliar.clickParaVerDias();
            }
        });*/


        happyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        neutralImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        sadImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auxiliar.clickParaVerMes();

            }
        });


        return v;
    }

    private void alocarUI(View v){
        teste = (Button)v.findViewById(R.id.teste);
        buttonData = (Button)v.findViewById(R.id.buttonData);
        happyImageView = (ImageView)v.findViewById(R.id.happyImageView);
        neutralImageView = (ImageView)v.findViewById(R.id.neutralImageView);
        sadImageView = (ImageView)v.findViewById(R.id.sadImageView);

    }
}
