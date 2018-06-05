package com.example.pitisflow.clothes;

/**
 * Creado por Hermosa Programación
 */
public class Anime {
    private int imagen;
    private String nombre;
    private int descargas;

    public Anime(int imagen, String nombre, int visitas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descargas = visitas;

    }

    public String getNombre() {
        return nombre;
    }

    public int getDescargas() {
        return descargas;
    }

    public int getImagen() {
        return imagen;
    }
}
