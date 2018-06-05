package com.example.pitisflow.clothes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Pitisflow on 27/6/17.
 */
public class Login extends AppCompatActivity {


    private Button empezar;
    private EditText textusuario;
    private EditText textpasswd;
    private Toolbar toolbar;
    private boolean flag = false, flag1 = flag, flag2 = flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        empezar = (Button) findViewById(R.id.Registrarse);
        textusuario = (EditText) findViewById(R.id.username);
        textpasswd = (EditText) findViewById(R.id.passwd);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("3dClothes");

        setSupportActionBar(toolbar);

        ActionBar bar = this.getSupportActionBar();

        bar.setDisplayHomeAsUpEnabled(false);


        flag = false;


        textusuario.addTextChangedListener(new TextValidator(textusuario) {
            // @Override
            public void validate(EditText editText, String text) {
                //Implementamos la validación que queramos
                if (text.length() < 2) {
                    textusuario.setError("Introduce un nombre");
                    flag = true;
                } else flag = false;
            }
        });


        textpasswd.addTextChangedListener(new TextValidator(textpasswd) {
            // @Override
            public void validate(EditText editText, String text) {
                //Implementamos la validación que queramos
                if (text.length() < 8) {
                    textpasswd.setError("La contraseña es corta (<8)");
                    flag = true;
                } else flag = false;
            }
        });


        Usuario miusuario = Usuario.nuevousuario();

        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String str = textusuario.getText().toString();
                String str2 = textpasswd.getText().toString();


                if (str.length() == 0 || str2.length() == 0) {
                    flag1 = true;
                    textusuario.setError("Completa los datos!");

                } else
                    flag1 = false;


                if (flag == false && flag1 == false) {


                    Usuario.user.setName(str);
                    Usuario.user.setPasswd(str2);


                    Intent empezar = new Intent(getApplicationContext(), Introduccion.class);


                    startActivity(empezar);
                }

            }
        });


    }


}
