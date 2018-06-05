package com.example.pitisflow.clothes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivitycard extends ActionBarActivity {

    /*
    Declarar instancias globales
     */
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincard);


        Usuario miusuario = Usuario.nuevousuario();


        String perfil_sexo2 = Usuario.user.getSexo();

        // Inicializar Animes
        List<Anime> items = new ArrayList<>();
        if (perfil_sexo2.equals("Masculino")) {
            items.add(new Anime(R.drawable.vaqueroazul, "vaquero", 230));
            items.add(new Anime(R.drawable.calzonazul, "calzoncillo", 456));
            items.add(new Anime(R.drawable.pantalonnegro, "Bañador negro", 342));
            items.add(new Anime(R.drawable.vaquerocorto, "vaquero corto", 645));
            items.add(new Anime(R.drawable.susaderaazul, "sudadera", 459));
            items.add(new Anime(R.drawable.camisazul, "camiseta azul", 59));
            items.add(new Anime(R.drawable.camisaverde, "camiseta verde", 459));
            items.add(new Anime(R.drawable.pantalonvaquero, "vaquero negro", 55));
            items.add(new Anime(R.drawable.vaqueroazul2, "vaquero azul", 459));
        } else {
            items.add(new Anime(R.drawable.vestidorojo, "vestido rojo", 459));
            items.add(new Anime(R.drawable.chaquetarosa, "chaqueta rosa", 1030));
            items.add(new Anime(R.drawable.deporterosa, "deportiva", 456));
            items.add(new Anime(R.drawable.banadorazul, "Bañador azul", 342));
            items.add(new Anime(R.drawable.vaqueromujer, "vaquero", 645));
            items.add(new Anime(R.drawable.camisaazul, "camisa", 459));
            items.add(new Anime(R.drawable.faldaazul, "falda azul", 59));
            items.add(new Anime(R.drawable.vaqueromujer2, "vaquero azul", 55));
            items.add(new Anime(R.drawable.vestidonegro, "vestido negro", 459));
        }


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new GridLayoutManager(this, 2);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new AnimeAdapter(items, this);
        recycler.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent empezar = new Intent(getApplicationContext(), Perfil.class);


                startActivity(empezar);
            }
        });


    }


}

