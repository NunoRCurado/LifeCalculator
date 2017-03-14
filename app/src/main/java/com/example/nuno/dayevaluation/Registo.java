package com.example.nuno.dayevaluation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nuno on 07-Mar-17.
 */

public class Registo extends Fragment {


    private Button confirmButton;
    private Button resetButton;
    private EditText username;
    private EditText password;
    private EditText confirmaPassword;
    private User pessoa;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registo, container, false);

        alocarUI(v);

        final Activity mActivity = this.getActivity();
        pessoa = new User();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username.setText("");
                password.setText("");
                confirmaPassword.setText("");

            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //criar o registo
                //Confirmar se registo ja existe(nao esta feito ainda)

                if (!username.getText().toString().isEmpty() &&
                        !password.getText().toString().isEmpty() && !confirmaPassword.getText().toString().isEmpty()) {
                    if(password.getText().toString() != confirmaPassword.getText().toString()){
                        Toast.makeText(mActivity, getString(R.string.check_password), Toast.LENGTH_SHORT).show();
                    }else{
                        pessoa.setPassword(password.getText().toString());
                        pessoa.setUsername(username.getText().toString());

                        Toast.makeText(mActivity, getString(R.string.registo_com_sucesso), Toast.LENGTH_SHORT).show();
                        mActivity.getFragmentManager().beginTransaction().remove(Registo.this).commit();

                    }
                }else{
                    Toast.makeText(mActivity, getString(R.string.campos_incompletos), Toast.LENGTH_SHORT).show();
                }

            }
        });


        return v;
    }

    private void alocarUI(View v) {

        confirmButton = (Button) v.findViewById(R.id.registoButtonConfirmation);
        resetButton = (Button) v.findViewById(R.id.resetRegistoButton);
        username = (EditText) v.findViewById(R.id.registoUsername);
        password = (EditText) v.findViewById(R.id.registoPass);
        confirmaPassword = (EditText) v.findViewById(R.id.registoConfirmaPass);
    }
}
