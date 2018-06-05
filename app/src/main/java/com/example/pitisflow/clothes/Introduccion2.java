package com.example.pitisflow.clothes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Introduccion2 extends AppCompatActivity {
    Button empezar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion2);


        empezar = (Button) findViewById(R.id.introduccion2comenzar);


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("3dClothes");

        setSupportActionBar(toolbar);

        ActionBar bar = this.getSupportActionBar();

        bar.setDisplayHomeAsUpEnabled(true);


        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent empezar = new Intent(Introduccion2.this, registrarperfil.class);


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
