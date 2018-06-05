package com.example.pitisflow.clothes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class registrarperfil extends ActionBarActivity {

    EditText textfnac;
    EditText textemail;
    EditText textpeso;
    private Toolbar toolbar;

    Button empezar;
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarperfil);
        Usuario miusuario = Usuario.nuevousuario();


        String user = Usuario.user.getName();

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("3dClothes");

        setSupportActionBar(toolbar);

        ActionBar bar = this.getSupportActionBar();

        bar.setDisplayHomeAsUpEnabled(true);


        TextView saludo = (TextView) findViewById(R.id.Saludo);
        final RadioButton radioButton = (RadioButton) findViewById(R.id.masculino);
        final Spinner spinner = (Spinner) findViewById(R.id.talla);
        textemail = (EditText) findViewById(R.id.email);
        textfnac = (EditText) findViewById(R.id.fnac);
        textpeso = (EditText) findViewById(R.id.peso);
        empezar = (Button) findViewById(R.id.comenzar);

        saludo.setText(user + "!");

        String[] valores = {"Talla", "S", "M", "L", "XL"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // vacio

            }
        });


        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (textemail.getText().toString().length() == 0) {
                    flag = true;
                    textemail.setError("Introduce un email!");

                } else
                    flag = false;


                if (flag == false) {


                    boolean estado = radioButton.isChecked();
                    if (estado) {
                        Usuario.user.setSexo("Masculino");
                    } else
                        Usuario.user.setSexo("Femenino");


                    Usuario.user.setCorreo(textemail.getText().toString());
                    Usuario.user.setFnac(textfnac.getText().toString());
                    if (textpeso.getText().toString().equals(""))
                        Usuario.user.setPeso(0);
                    else
                        Usuario.user.setPeso(Integer.valueOf(textpeso.getText().toString()));
                    Usuario.user.setTalla(spinner.getSelectedItem().toString());


                    Intent empezar = new Intent(getBaseContext(), MainActivitycard.class);


                    startActivity(empezar);
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
