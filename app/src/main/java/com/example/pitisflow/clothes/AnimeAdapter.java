package com.example.pitisflow.clothes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Creado por Hermosa Programación
 */
public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private List<Anime> items;
    private Context context;
    private static MyClickListener myClickListener;


    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }


    public AnimeAdapter(List<Anime> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.anime_card, viewGroup, false);

        AnimeViewHolder dataObjectHolder = new AnimeViewHolder(v);


        return dataObjectHolder;

    }

    @Override
    public void onBindViewHolder(AnimeViewHolder viewHolder, final int i) {


        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.visitas.setText("Impresiones:" + String.valueOf(items.get(i).getDescargas()));


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Cloth.class);
                intent.putExtra("nombre", items.get(i).getNombre());
                intent.putExtra("impresiones", items.get(i).getDescargas());
                intent.putExtra("imagen", items.get(i).getImagen());
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;


        public AnimeViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);

        }

    }


}


