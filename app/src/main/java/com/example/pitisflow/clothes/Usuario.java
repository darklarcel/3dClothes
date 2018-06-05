package com.example.pitisflow.clothes;

/**
 * Created by Darklarcel on 25/06/2017.
 */

public class Usuario {

    public static Usuario user;

    private static String Nombre;
    private static String Passwd;
    private static String Sexo;
    private static String Correo;
    private static String Fnac;
    private static Integer Peso;
    private static String Talla;


    public static Usuario nuevousuario() {
        if (user == null) {
            user = new Usuario();
        }
        return user;
    }

    private Usuario() {

    }


    public void setName(String name) {
        this.Nombre = name;
    }

    public String getName() {
        return this.Nombre;
    }


    public void setPasswd(String psswd) {
        this.Passwd = psswd;
    }

    public String getPasswd() {
        return this.Passwd;
    }


    public static String getCorreo() {
        return Correo;
    }

    public static void setCorreo(String correo) {
        Correo = correo;
    }


    public static String getSexo() {
        return Sexo;
    }

    public static void setSexo(String sexo) {
        Sexo = sexo;
    }


    public static Integer getPeso() {
        return Peso;
    }

    public static void setPeso(Integer peso) {
        Peso = peso;
    }

    public static String getTalla() {
        return Talla;
    }

    public static void setTalla(String talla) {
        Talla = talla;
    }

    public static String getFnac() {
        return Fnac;
    }

    public static void setFnac(String fnac) {
        Fnac = fnac;
    }
}
