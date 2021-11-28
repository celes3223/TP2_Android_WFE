package com.example.tp2_android_wfe.entidades;

public class Detalle {

    private Productos producto;
    private int cantidad;
    private int total_detalle;

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal_detalle() {
        return total_detalle;
    }

    public void setTotal_detalle(int total_detalle) {
        this.total_detalle = total_detalle;
    }
}
