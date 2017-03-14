package com.example.nuno.dayevaluation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Nuno on 08-Mar-17.
 */

public class FragmentoMeses extends Fragment {

    private AdapterMeses mAdapter;
    private Auxiliar auxiliar;


    private int[] mediaCores = new int[]{0, 1, 2, 2, 2, 1, 0, 0, 2, 1, 2, 0};
    private String[] listMeses = {"JAN", "FEV","MAR","ABR","MAI","JUN","JUL","AGO","SET","OUT","NOV","DEZ"};

    private GridView gridView;
    private TextView totalBom;
    private TextView totalNormal;
    private TextView totalMau;
    private int db;
    private int dn;
    private int dm;


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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.calendario_anual, null);
        final Activity mActivity = this.getActivity();

        alocarUI(v);

        db = 0;
        dn = 0;
        dm = 0;

        db = contaDiasBons(db,mediaCores);
        dn = contaDiasNormais(dn,mediaCores);
        dm = contaDiasMaus(dm,mediaCores);

        totalBom.setText("Total de dias bons: "+ db);
        totalNormal.setText("Total de dias normais: "+ dn);
        totalMau.setText("Total de dias maus: "+ dm);

        AdapterMeses mAdapter = new AdapterMeses(getActivity(),listMeses, mediaCores);

        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                auxiliar.clickParaVerDias(position);

            }
        });



        return v;
    }


    private int contaDiasMaus(int dn, int[] medias) {

        for(int i = 0; i<medias.length;i++){
            if(medias[i] ==0){
                dn++;
            }
        }
        return dn;

    }

    private int contaDiasNormais(int dn, int[] medias) {

        for(int i = 0; i<medias.length;i++){
            if(medias[i] == 1){
                db++;
            }
        }
        return db;

    }

    private int contaDiasBons(int db,int[] medias){

        for(int i = 0; i<medias.length;i++){
            if(medias[i] == 2){
                db++;
            }
        }
        return db;
    }


    private void alocarUI(View v){

        gridView = (GridView) v.findViewById(R.id.calendario_ano_grid);
        totalBom = (TextView)v.findViewById(R.id.totalBomTextView);
        totalNormal = (TextView)v.findViewById(R.id.totalNormalTextView);
        totalMau = (TextView)v.findViewById(R.id.totalMauTextView);

    }
}
