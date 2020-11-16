package com.ajsb.testobservable;

/**
 * Programación Multimedia y de Dispositivos Móviles
 * Antonio J.Sánchez
 * curso 2020|21
 */

import java.util.Observable;

public class Usuario extends Observable
{

    private String nombre ;
    private String apellidos ;
    private String foto ;

    /**
     * @param nombre
     * @param apellidos
     * @param foto
     */
    public Usuario(String nombre, String apellidos, String foto)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.foto = foto;

        setChanged();
    }

    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        setChanged() ;
        notifyObservers();
    }

    /**
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
        setChanged();
        notifyObservers();
    }

    /**
     * @return
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
        setChanged();
        notifyObservers();

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return nombre + " " + apellidos ;
    }
}
