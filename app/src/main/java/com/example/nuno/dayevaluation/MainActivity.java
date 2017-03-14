package com.example.nuno.dayevaluation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Stack;


public class MainActivity extends AppCompatActivity implements Auxiliar {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButtonConfirmation;
    private Button cancelButtonConfirmation;
    private Button registoButton;
    private Button loginButtonDialog;
    private AlertDialog alertD;
    private FrameLayout mFrameLayout;

    public int getPosition() {
        return position;
    }

    private int position;

    //user
    private User pessoa;


    //Frags
    private CalendarioDias calendarioDias;
    private Registo fragmentoRegisto;
    private FragmentoMenu fragmentoMenu;
    private FragmentoMeses fragmentoMeses;




    private Fragment mCurrentFrag;
    private Stack<Fragment> mStackFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        position = 0;
        pessoa = new User();

        mFrameLayout = (FrameLayout)findViewById(R.id.frameParaFrags);

        //Fragmentos
        fragmentoRegisto = new Registo();
        fragmentoMenu = new FragmentoMenu();
        fragmentoMeses = new FragmentoMeses();
        calendarioDias = new CalendarioDias();

        //Stack de fragmentos

        mStackFragments = new Stack<Fragment>();


        //Botoes Login
        loginButtonDialog = (Button)findViewById(R.id.loginButton);
        registoButton = (Button)findViewById(R.id.registoButton);


        registoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               ShowFragment(fragmentoRegisto);
            }
        });


        loginButtonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder mbBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);

                usernameEditText = (EditText) mView.findViewById(R.id.username_login);
                passwordEditText = (EditText) mView.findViewById(R.id.username_pass);
                loginButtonConfirmation = (Button) mView.findViewById(R.id.loginButtonConfirmation);
                cancelButtonConfirmation = (Button)mView.findViewById(R.id.cancelButtonConfirmation);

                cancelButtonConfirmation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertD.dismiss();
                    }
                });

                loginButtonConfirmation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!usernameEditText.getText().toString().isEmpty() &&
                                !passwordEditText.getText().toString().isEmpty()){
                            //verificar se login existe
                            /*----*/
                            //se existir
                            Toast.makeText(MainActivity.this, R.string.login_com_sucesso, Toast.LENGTH_SHORT).show();
                            loginButtonDialog.setText(R.string.fazer_logout);
                            alertD.dismiss();
                            ShowFragment(fragmentoMenu);

                        }else{
                            Toast.makeText(MainActivity.this, R.string.campos_incompletos, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                mbBuilder.setView(mView);
                alertD = mbBuilder.create();
                alertD.show();
            }
        });

    }

    private void ShowFragment(Fragment frag){

        if(frag.isVisible()){
            return;
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(mCurrentFrag!=null){
            fragmentTransaction.hide(mCurrentFrag);
        }

        fragmentTransaction.add(R.id.frameParaFrags,frag, null );
        fragmentTransaction.show(frag);

        //nao sei se funciona
        fragmentTransaction.addToBackStack(null);
        mStackFragments.push(mCurrentFrag);
        fragmentTransaction.commit();

        mCurrentFrag = frag;

    }


    @Override
    public void clickParaVerMes() {

        ShowFragment(fragmentoMeses);
    }

    @Override
    public int clickParaVerDias(int position) {

        ShowFragment(calendarioDias);
        this.position= position;
        return this.position;
    }
}
