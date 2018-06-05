package com.example.pitisflow.clothes;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static android.R.attr.delay;

public class Cloth extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);

        Intent intent = getIntent();


        Usuario miusuario = Usuario.nuevousuario();


        String perfil_talla2 = Usuario.user.getTalla();


        View containerNombre = findViewById(R.id.nombre);
        View containerVisitas = findViewById(R.id.visitas);
        final Spinner spinner = (Spinner) findViewById(R.id.clothe_talla);
        final Spinner spinnercolor = (Spinner) findViewById(R.id.clothe_color);
        final Spinner spinnermaterial = (Spinner) findViewById(R.id.clothe_material);


        String[] valores = {perfil_talla2, "S", "M", "L", "XL"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));

        String[] colores = {"Blanco", "Verde", "Azul", "Rojo", "Negro", "Marron"};
        spinnercolor.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colores));

        String[] materiales = {"Lana", "Nylon", "Poliester"};
        spinnermaterial.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materiales));

        ((TextView) containerNombre.findViewById(R.id.field_name)).setText("Nombre");
        ((TextView) containerNombre.findViewById(R.id.field_data)).setText(intent.getStringExtra("nombre"));


        ((TextView) containerVisitas.findViewById(R.id.field_name)).setText("Impresiones");
        ((TextView) containerVisitas.findViewById(R.id.field_data)).setText("" + intent.getIntExtra("impresiones", 2));


        ((ImageView) findViewById(R.id.cloth_image)).setImageResource(intent.getIntExtra("imagen", 2));


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("3dClothes");

        setSupportActionBar(toolbar);

        ActionBar bar = this.getSupportActionBar();

        bar.setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_clothes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Imprimiendo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


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

