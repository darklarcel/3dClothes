package com.example.pitisflow.clothes;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import static com.example.pitisflow.clothes.R.id.perfil;

public class Perfil extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView perfil_nombre;
    private TextView perfil_fnac;
    private TextView perfil_correo;
    private TextView perfil_peso;
    private Button guardar;
    private Boolean flag = false;

    private Boolean flag1 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("3dClothes");
        setSupportActionBar(toolbar);
        ActionBar bar = this.getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);


        Usuario miusuario = Usuario.nuevousuario();


        String perfil_nombre1 = Usuario.user.getName();
        String perfil_correo1 = Usuario.user.getCorreo();
        String perfil_fnac1 = Usuario.user.getFnac();
        String perfil_peso1 = String.valueOf(Usuario.user.getPeso());
        String perfil_talla1 = Usuario.user.getTalla();
        String perfil_sexo1 = Usuario.user.getSexo();


        perfil_nombre = (TextView) findViewById(R.id.perfil_nombre);
        perfil_fnac = (TextView) findViewById(R.id.perfil_fnac);
        perfil_correo = (TextView) findViewById(R.id.perfil_correo);
        perfil_peso = (TextView) findViewById(R.id.perfil_peso);
        guardar = (Button) findViewById(R.id.modificar_perfil);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner_perfil);
        final RadioButton perfil_masculino1 = (RadioButton) findViewById(R.id.perfil_masculino);
        final RadioButton perfil_femenino1 = (RadioButton) findViewById(R.id.perfil_femenino);

        perfil_nombre.setText("" + perfil_nombre1);
        perfil_fnac.setText("" + perfil_fnac1);
        perfil_correo.setText("" + perfil_correo1);
        perfil_peso.setText("" + perfil_peso1);


        String[] valores = {perfil_talla1, "S", "M", "L", "XL"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));


        if (perfil_sexo1.equals("Masculino")) {
            perfil_masculino1.setChecked(true);
        } else
            perfil_femenino1.setChecked(true);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                flag = false;
                flag1 = false;


                if (perfil_nombre.length() < 2) {
                    perfil_nombre.setError("Introduce un nombre");
                    flag1 = true;
                } else flag1 = false;


                if (perfil_correo.getText().toString().length() == 0) {
                    flag = true;
                    perfil_correo.setError("Introduce un email!");

                } else
                    flag = false;


                if (flag == false && flag1 == false) {


                    boolean estado = perfil_masculino1.isChecked();
                    if (estado) {
                        Usuario.user.setSexo("Masculino");
                    } else
                        Usuario.user.setSexo("Femenino");

                    Usuario.user.setName(perfil_nombre.getText().toString());
                    Usuario.user.setCorreo(perfil_correo.getText().toString());
                    Usuario.user.setFnac(perfil_fnac.getText().toString());
                    if (perfil_peso.getText().toString().equals(""))
                        Usuario.user.setPeso(0);
                    else
                        Usuario.user.setPeso(Integer.valueOf(perfil_peso.getText().toString()));
                    Usuario.user.setTalla(spinner.getSelectedItem().toString());


                    Snackbar.make(v, "Guardado", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_perfil);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent empezar = new Intent(getApplicationContext(), MainActivitycard.class);


                startActivity(empezar);
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
