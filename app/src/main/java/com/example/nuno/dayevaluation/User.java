package com.example.nuno.dayevaluation;

import java.util.ArrayList;

/**
 * Created by Nuno on 10-Mar-17.
 */

public class User {

    private int id;


    ArrayList<Dias>Meses;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Dias> getMeses() {
        return Meses;
    }

    public void setMeses(ArrayList<Dias> meses) {
        Meses = meses;
    }


}
