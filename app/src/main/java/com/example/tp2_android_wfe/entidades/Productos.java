package com.example.tp2_android_wfe.entidades;

public class Productos {

    private int id;
    private String codigo;
    private String nombre;
    private String precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String existencia;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }
}
