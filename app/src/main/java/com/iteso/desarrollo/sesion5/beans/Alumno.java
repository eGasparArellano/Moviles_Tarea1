package com.iteso.desarrollo.sesion5.beans;

/**
 * Created by Desarrollo on 04/09/2017.
 */

public class Alumno {
    private String nombre;
    private String telefono;
    private String escolaridad;
    private String genero;
    private String libroFavorito;
    private Boolean deporte;

    @Override
    public String toString() {
        String resumen;
        String deporte;
        if(this.deporte)
            deporte = "Sí";
        else
            deporte = "No";

        if(libroFavorito.isEmpty())
            resumen =   "Alumno: " + nombre + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Escolaridad: " + escolaridad + "\n" +
                        "Género: " + genero + "\n" +
                        "Practica deporte: " + deporte;
        else
            resumen =   "Alumno: " + nombre + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Escolaridad: " + escolaridad + "\n" +
                        "Género: " + genero + "\n" +
                        "Libro favorito: " + libroFavorito + "\n" +
                        "Practica deporte: " + deporte;
        return resumen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLibroFavorito() {
        return libroFavorito;
    }

    public void setLibroFavorito(String libroFavorito) {
        this.libroFavorito = libroFavorito;
    }

    public Boolean getDeporte() {
        return deporte;
    }

    public void setDeporte(Boolean deporte) {
        this.deporte = deporte;
    }
}
